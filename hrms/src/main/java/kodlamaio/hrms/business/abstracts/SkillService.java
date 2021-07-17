package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Skill;

public interface SkillService {
	DataResult<List<Skill>> getAll();
}
