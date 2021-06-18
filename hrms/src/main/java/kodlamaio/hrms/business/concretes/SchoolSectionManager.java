package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolSectionService;

import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.SchoolSectionDao;
import kodlamaio.hrms.entities.concretes.SchoolSection;
import kodlamaio.hrms.entities.dtos.SchoolSectionDto;
import net.bytebuddy.asm.Advice.This;

@Service
public class SchoolSectionManager implements SchoolSectionService {
	@Autowired
	private SchoolSectionDao schoolSectionDao;

	@Override
	public DataResult<List<SchoolSection>> getAll() {
		return new SuccessDataResult<List<SchoolSection>>(this.schoolSectionDao.findAll());
	}

	@Override
	public Result add(SchoolSection scholSection) {
		this.schoolSectionDao.save(scholSection);
		return new SuccessResult("Okul bilgisi eklendi.");
	}

	@Override
	public DataResult<List<SchoolSectionDto>> getSchoolSectionDetails(int cvId) {
		return new SuccessDataResult<List<SchoolSectionDto>>(this.schoolSectionDao.getSchoolSectionDto(cvId));
	}

}
