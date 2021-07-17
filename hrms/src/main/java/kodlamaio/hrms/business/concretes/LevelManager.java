package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LevelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.LevelDao;
import kodlamaio.hrms.entities.concretes.Level;

@Service
public class LevelManager implements LevelService {
	@Autowired
	LevelDao levelDao;

	@Override
	public DataResult<List<Level>> getAll() {
		return new SuccessDataResult<List<Level>>(this.levelDao.findAll());
	}
	
	
}
