package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.MyFavouriteService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.MyFavouriteDao;
import kodlamaio.hrms.entities.concretes.MyFavourite;

@Service
public class MyFavouriteManager implements MyFavouriteService {
	@Autowired
	private MyFavouriteDao myFavouriteDao;

	@Override
	public Result add(MyFavourite myFavourite) {
		this.myFavouriteDao.save(myFavourite);
		return new SuccessResult("Favorilerime Eklendi.");
	}

	@Override
	public Result insertCandidateAndJobPosting(int candidateId, int jobPostingId) {
		this.myFavouriteDao.insertCandidateAndJobPosting(candidateId, jobPostingId);
		return new SuccessResult("başarılı");
	}

}
