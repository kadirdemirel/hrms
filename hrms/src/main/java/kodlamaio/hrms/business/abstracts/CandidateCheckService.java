package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateCheckService {
	boolean CheckIfRealPerson(Candidate candidate);

}
