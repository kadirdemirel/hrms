package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvSkill;
import kodlamaio.hrms.entities.dtos.CvSkillDto;

public interface CvSkillService {
	public DataResult<List<CvSkill>> getAll();

	public Result add(CvSkill cvSkill);

	DataResult<List<CvSkillDto>> getCvSkillDetails(int cvId);
}
