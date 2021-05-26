package kodlamaio.hrms.business.concretes;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;

import kodlamaio.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {

		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll());
	}

	@Override
	public Result add(JobTitle jobTitle) {
		for (JobTitle jobTitleCheck : this.jobTitleDao.findAll()) {
			if (!jobTitleCheck.getTitle().equals(jobTitle.getTitle())) {
				this.jobTitleDao.save(jobTitle);
				return new SuccessResult("Genel iş pozisyonu başarıyla eklendi.");
			} else {
				return new ErrorResult("Böyle bir genel iş pozisyonu bulunmaktadır.");
			}
		}
		return null;

	}

}
