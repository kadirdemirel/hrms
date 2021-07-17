package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageLevelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageLevelDao;
import kodlamaio.hrms.entities.concretes.LanguageLevel;
import kodlamaio.hrms.entities.dtos.LanguageLevelDto;

@Service
public class LanguageLevelManager implements LanguageLevelService {
	@Autowired
	private LanguageLevelDao languageLevelDao;

	@Override
	public DataResult<List<LanguageLevel>> getAll() {
		return new SuccessDataResult<List<LanguageLevel>>(this.languageLevelDao.findAll());
	}

	@Override
	public Result add(LanguageLevel languageLevel) {
		this.languageLevelDao.save(languageLevel);
		return new SuccessResult("Yabancı Dil bilgisi eklendi.");
	}

	@Override
	public DataResult<List<LanguageLevelDto>> getLanguageLevelDetails(int cvId) {
		return new SuccessDataResult<List<LanguageLevelDto>>(this.languageLevelDao.getLanguageLevelDto(cvId));
	}

	@Override
	public Result languageLevel(int languageId, int levelId, int id) {
		this.languageLevelDao.languageLevel(languageId, levelId, id);
		return new SuccessResult("Yabancı dil bilgisi güncellendi");
	}

}
