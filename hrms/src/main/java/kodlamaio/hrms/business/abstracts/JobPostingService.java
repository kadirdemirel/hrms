package kodlamaio.hrms.business.abstracts;

import java.util.List;



import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.PageableDto;

public interface JobPostingService {
	Result add(JobPosting jobPosting);

	DataResult<List<JobPosting>> getAll();

	DataResult<List<JobPosting>> getByStatus(int status);

	DataResult<List<JobPosting>> getAllStatusAndDate(int status);

	DataResult<List<JobPosting>> getByStatusAndEmployerId(int status, int employerId);

	Result Update(JobPosting jobPosting);

	Result updateStatus(int status, int id);


	DataResult<JobPosting> getById(int id);

    DataResult<List<JobPosting>> getByFilter(int pageNo, int pageSize, PageableDto pageableDto);
//	DataResult<PageableDto<List<JobPosting>>> getAll(int pageNo, int pageSize);
//	DataResult<PageableDto<List<JobPosting>>> getByCityIdAndTypeOfWorkId(int cityId,int typeOfWorkId,int pageNo,int pageSize);

//	DataResult<List<JobPosting>> getByCityIdAndTypeOfWorkId(int cityId, int typeOfWorkId);
}
