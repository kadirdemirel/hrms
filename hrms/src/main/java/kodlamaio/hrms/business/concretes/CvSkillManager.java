package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvSkillDao;
import kodlamaio.hrms.entities.concretes.CvSkill;
import kodlamaio.hrms.entities.dtos.CvSkillDto;

@Service
public class CvSkillManager implements CvSkillService {

	@Autowired
	private CvSkillDao cvSkillDao;

	@Override
	public DataResult<List<CvSkill>> getAll() {
		return new SuccessDataResult<List<CvSkill>>(this.cvSkillDao.findAll());
	}

	@Override
	public Result add(CvSkill cvSkill) {
		this.cvSkillDao.save(cvSkill);
		return new SuccessResult("Beceri bilgisi eklendi.");
	}

	@Override
	public DataResult<List<CvSkillDto>> getCvSkillDetails(int cvId) {
		return new SuccessDataResult<List<CvSkillDto>>(this.cvSkillDao.getCvSkillDto(cvId));
	}
}
