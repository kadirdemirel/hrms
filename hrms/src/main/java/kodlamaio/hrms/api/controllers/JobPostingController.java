package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.PageableDto;

@RestController
@RequestMapping("/api/jobpostings")
@CrossOrigin
public class JobPostingController {
	@Autowired
	JobPostingService jobPostingService;

	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {

		return this.jobPostingService.add(jobPosting);
	}

	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll() {
		return this.jobPostingService.getAll();
	}

	@GetMapping("/getalltrue")
	public DataResult<List<JobPosting>> getByStatus(int status) {
		return this.jobPostingService.getByStatus(status);
	}

	@GetMapping("/getallstatusanddate")
	public DataResult<List<JobPosting>> getByStatus2(int status) {
		return this.jobPostingService.getAllStatusAndDate(status);
	}

	@GetMapping("/getbystatusandemployer")
	public DataResult<List<JobPosting>> getByStatusAndEmployerId(int status, int employerId) {
		return this.jobPostingService.getByStatusAndEmployerId(status, employerId);
	}

	@PostMapping("/update")
	public Result updateStatus(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.Update(jobPosting);

	}

	@PostMapping("/statusUpdate")
	public Result updateStatus(@RequestParam("status") int status, @RequestParam("id") int id) {
		return this.jobPostingService.updateStatus(status, id);

	}

	@GetMapping("/getById")
	public DataResult<JobPosting> getById(int id) {
		return this.jobPostingService.getById(id);
	}

//	@GetMapping("/getAllByPage")
//	DataResult<PageableDto<List<JobPosting>>> getAll(int pageNo, int pageSize) {
//		
//		return this.jobPostingService.getAll(pageNo, pageSize);
//	}

	// @GetMapping("/getByCityIdAndTypeOfWorkId")
	// DataResult<List<JobPosting>> getByCityIdAndTypeOfWorkId(int cityId, int
	// typeOfWorkId) {
	// return this.jobPostingService.getByCityIdAndTypeOfWorkId(cityId,
	// typeOfWorkId);
//	}

	@PostMapping("/getByFilter")
	public Result getByFilter(@RequestParam int pageNo, @RequestParam int pageSize,
			@RequestBody PageableDto pageableDto) {
		System.out.println(pageNo);
		System.out.println(pageSize);
		System.out.println(pageableDto);
		return jobPostingService.getByFilter(pageNo, pageSize, pageableDto);
		
	}

}
