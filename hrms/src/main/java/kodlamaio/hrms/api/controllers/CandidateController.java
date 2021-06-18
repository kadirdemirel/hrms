package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidateController {
	@Autowired
	private CandidateService candidateService;

	@PostMapping("/add")
	public Result add(@RequestBody CandidateForRegisterDto candidateForRegisterDto) {
		return this.candidateService.add(candidateForRegisterDto);
	}

	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll() {
		return this.candidateService.getAll();
	}
}
