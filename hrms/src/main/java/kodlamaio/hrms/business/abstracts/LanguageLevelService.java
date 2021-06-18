package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.LanguageLevel;
import kodlamaio.hrms.entities.dtos.LanguageLevelDto;


public interface LanguageLevelService {
	public DataResult<List<LanguageLevel>> getAll();

	public Result add(LanguageLevel languageLevel);

	DataResult<List<LanguageLevelDto>> getLanguageLevelDetails(int cvId);
}
