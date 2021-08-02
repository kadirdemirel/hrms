package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
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

	@PutMapping("/updateEmployer")
	public Result updateEmployer(@RequestParam("companyName") String companyName, @RequestParam("phone") String phone, @RequestParam("status") boolean status,
			@RequestParam("id") int id) {
		return this.employerService.updateEmployer(companyName, phone, status,id);
	}

	@PutMapping("/updateEmployerClone")
	public Result updateEmployerClone(@RequestParam("companyNameClone") String companyNameClone,
			@RequestParam("phoneClone") String phoneClone,@RequestParam("status") boolean status, @RequestParam("id") int id) {
		return this.employerService.updateEmployerClone(companyNameClone, phoneClone,status, id);
	}

	@GetMapping("/getById")
	public DataResult<Employer> getById(@RequestParam("Id") int id) {
		return this.employerService.getById(id);
	}

}
