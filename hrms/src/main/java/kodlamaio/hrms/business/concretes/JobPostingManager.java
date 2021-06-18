package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService {

	@Autowired
	JobPostingDao jobPostingDao;

	@Override
	public Result add(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("Başarılı");
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {

		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll());
	}

	@Override
	public DataResult<List<JobPosting>> getAllStatusAndDate(boolean status) {
		Sort sort = Sort.by(Sort.Direction.ASC, "lastDate");
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByStatus(status, sort));
	}

	@Override
	public DataResult<List<JobPosting>> getByStatusAndEmployerId(int status, int employerId) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByStatusAndEmployerId(status, employerId));
	}

	@Override
	public Result Update(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobPosting>> getByStatus(@RequestParam("status") int status) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByStatus(status));
	}

	@Override
	public Result updateStatus(int status, int id) {
		this.jobPostingDao.updateStatus(status, id);
		return new SuccessResult();
	}

}
