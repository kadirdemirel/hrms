package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.MyFavourite;

public interface MyFavouriteService {
	Result add(MyFavourite myFavourite);
	Result insertCandidateAndJobPosting(int candidateId, int jobPostingId);
}
