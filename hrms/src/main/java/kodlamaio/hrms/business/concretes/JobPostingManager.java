package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import kodlamaio.hrms.entities.dtos.PageableDto;

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
	public DataResult<List<JobPosting>> getAllStatusAndDate(int status) {
		Sort sort = Sort.by(Sort.Direction.DESC, "lastDate");
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

	@Override
	public DataResult<JobPosting> getById(int id) {
		return new SuccessDataResult<JobPosting>(this.jobPostingDao.getById(id));
	}

	@Override
	public DataResult<List<JobPosting>> getByFilter(int pageNo, int pageSize, PageableDto pageableDto) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<JobPosting>>(
				this.jobPostingDao.getByFilter(pageableDto, pageable).getContent(),
				this.jobPostingDao.getByFilter(pageableDto, pageable).getTotalElements() + "");
	}

//	@Override
//	public DataResult<PageableDto<List<JobPosting>>> getAll(int pageNo, int pageSize) {
//
//		int a = this.jobPostingDao.findAll().toArray().length;
//		int z=a;
//
//		if (a % pageSize == 0) {
//			a = a / pageSize;
//		} else {
//			a = a / pageSize + 1;
//		}
//
//		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
//
//		PageableDto<List<JobPosting>> b = new PageableDto<List<JobPosting>>();
//		b.setListData(this.jobPostingDao.findAll(pageable).getContent());
//		b.setPageNo(pageNo);
//		b.setPageSize(pageSize);
//		b.setSection(a);
//		b.setTotalData(z);
//
//		SuccessDataResult<PageableDto<List<JobPosting>>> c = new SuccessDataResult<PageableDto<List<JobPosting>>>(b);
//
//		return c;
//
//	}

//	@Override
//	public DataResult<PageableDto<List<JobPosting>>> getByCityIdAndTypeOfWorkId(int cityId, int typeOfWorkId,
//			int pageNo, int pageSize) {
//		int a = this.jobPostingDao.findAll().toArray().length;
//		int z = a;
//
//		if (a % pageSize == 0) {
//			a = a / pageSize;
//		} else {
//			a = a / pageSize + 1;
//		}
//
//		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
//
//		PageableDto<List<JobPosting>> b = new PageableDto<List<JobPosting>>();
//		b.setListData(this.jobPostingDao.findAll(pageable).getContent());
//		b.setPageNo(pageNo);
//		b.setPageSize(pageSize);
//		b.setSection(a);
//		b.setTotalData(z);
//
//		SuccessDataResult<PageableDto<List<JobPosting>>> c = new SuccessDataResult<PageableDto<List<JobPosting>>>(b);
//
//		return c;
//	}

//	@Override
//	public DataResult<List<JobPosting>> getByCityIdAndTypeOfWorkId(int cityId, int typeOfWorkId) {
//		return new SuccessDataResult<List<JobPosting>>(
//				this.jobPostingDao.getByCityIdAndTypeOfWorkId(cityId, typeOfWorkId));
//	}

}
