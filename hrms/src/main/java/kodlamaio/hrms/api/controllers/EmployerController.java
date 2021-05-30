package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {
	@Autowired
	EmployerService employerService;

	@PostMapping("/add")
	public Result add(@RequestBody EmployerForRegisterDto employerForRegisterDto) {
		return this.employerService.add(employerForRegisterDto);
	}

	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll() {
		return this.employerService.getAll();
	}


}
