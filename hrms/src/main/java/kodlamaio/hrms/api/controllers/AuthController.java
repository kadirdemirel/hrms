package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;

@RestController
@RequestMapping("/api/auths")
public class AuthController {
	@Autowired
	AuthService authService;

	@PostMapping("/registercandidate")
	public void registerCandidate(CandidateForRegisterDto candidateForRegisterDto) {
		this.authService.registerCandidate(candidateForRegisterDto);
	}

	@PostMapping("/registeremployer")
	public void registerEmployer(EmployerForRegisterDto employerForRegisterDto) {
		this.authService.registerEmployer(employerForRegisterDto);
	}

}
