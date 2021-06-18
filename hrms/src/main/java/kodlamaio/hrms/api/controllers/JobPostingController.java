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

import io.swagger.models.Swagger;
import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

import kodlamaio.hrms.entities.concretes.JobPosting;

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
	public DataResult<List<JobPosting>> getByStatus2(boolean status) {
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

}
