package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.entities.concretes.Cv;
import net.bytebuddy.asm.Advice.This;

@Service
public class CvManager implements CvService {
	@Autowired
	CvDao cvDao;

	@Override
	public DataResult<List<Cv>> getByYearOfGraduation(Cv cv) {
		Sort sort = Sort.by(Sort.Direction.DESC, "yearOfGraduation");

		return new SuccessDataResult<List<Cv>>(this.cvDao.getByYearOfGraduation(cv.getYearOfGraduation(), sort));

	}

	@Override
	public DataResult<List<Cv>> getByYearOff(Cv cv) {
		Sort sort = Sort.by(Sort.Direction.DESC, "yearOff");
		return new SuccessDataResult<List<Cv>>(this.cvDao.getByYearOff(cv.getYearOff(), sort));
	}

	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult("Cv ekleme başarılı");
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll());
	}

	@Override
	public DataResult<Cv> getById(int id) {
		return new SuccessDataResult<Cv>(this.cvDao.getById(id));
	}

}
