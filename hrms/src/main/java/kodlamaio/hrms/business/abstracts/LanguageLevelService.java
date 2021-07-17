package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.LanguageLevel;
import kodlamaio.hrms.entities.dtos.LanguageLevelDto;

public interface LanguageLevelService {
	DataResult<List<LanguageLevel>> getAll();

	Result add(LanguageLevel languageLevel);

	DataResult<List<LanguageLevelDto>> getLanguageLevelDetails(int cvId);

	Result languageLevel(int languageId, int levelId, int id);
}
