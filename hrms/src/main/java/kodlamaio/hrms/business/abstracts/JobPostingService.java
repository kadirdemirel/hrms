package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	Result add(JobPosting jobPosting);

	DataResult<List<JobPosting>> getAll();

	DataResult<List<JobPosting>> getByStatus(int status);

	DataResult<List<JobPosting>> getAllStatusAndDate(int status);

	DataResult<List<JobPosting>> getByStatusAndEmployerId(int status, int employerId);

	Result Update(JobPosting jobPosting);
	
	Result updateStatus(int status,int id);



}
