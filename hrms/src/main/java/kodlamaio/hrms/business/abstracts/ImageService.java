package kodlamaio.hrms.business.abstracts;

import java.util.List;


import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;

public interface ImageService {

	Result add(Image image);

	DataResult<List<Image>> getAllByCvId(int imageId);

	Result addAll(List<Image> image);

	DataResult<List<Image>> getAll();

	Result add(Image image, MultipartFile file);

//	Result imageUpdate(String url, int id);
}
