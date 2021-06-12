package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.imageuploads.ImageUploadService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.Image;

@Service
public class ImageManager implements ImageService {

	private ImageDao imageDao;
	private ImageUploadService imageUploadService;

	@Autowired
	public ImageManager(ImageDao imageDao, ImageUploadService imageUploadService) {
		super();
		this.imageDao = imageDao;
		this.imageUploadService = imageUploadService;
	}

	@Override
	public Result add(Image image) {
		this.imageDao.save(image);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Image>> getAllByCandidateId(int imageId) {
		return new SuccessDataResult<List<Image>>(this.imageDao.getAllByCvId(imageId));
	}

	@Override
	public Result addAll(List<Image> image) {
		imageDao.saveAll(image);
		return new SuccessResult();

	}

	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll());
	}

	@Override
	public Result add(Image image, MultipartFile file) {
		Map<String, String> result = (Map<String, String>) imageUploadService.save(file).getData();
		String url = result.get("url");
		image.setUrl(url);
		image.setUploadedDate(LocalDate.now());
	
		return add(image);

	}

}