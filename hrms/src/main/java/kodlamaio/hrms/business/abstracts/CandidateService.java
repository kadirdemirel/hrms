package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;

public interface CandidateService {

	Result add(CandidateForRegisterDto candidateForRegisterDto);

	DataResult<List<Candidate>> getAll();

}
