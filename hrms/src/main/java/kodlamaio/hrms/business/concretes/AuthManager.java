package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;
import lombok.var;

@Service
public class AuthManager implements AuthService {
	@Autowired
	CandidateService candidateService;
	@Autowired
	EmployerService employerService;

	@Override
	public Result registerCandidate(CandidateForRegisterDto candidateForRegisterDto) {
		var user = new Candidate();
		user.setId(candidateForRegisterDto.getId());
		user.setFirstName(candidateForRegisterDto.getFirstName());
		user.setLastName(candidateForRegisterDto.getLastName());
		user.setBirthDate(LocalDate.parse(candidateForRegisterDto.getBirthDate()));
		user.setIdentificationNumber(candidateForRegisterDto.getIdentificationNumber());
		user.setEmailAddress(candidateForRegisterDto.getEmailAddress());
		user.setPassword(candidateForRegisterDto.getPassword());

		if (user.getPassword() == candidateForRegisterDto.getRepeatPassword()) {
			this.candidateService.add(user);
			return new SuccessResult("Kullanıcı başarıyla eklendi.");

		} else {
			return new ErrorResult("Yazdığınız şifreler birbiriyle uyuşmuyor lütfen kontrol ediniz.");
		}

	}

	@Override
	public Result registerEmployer(EmployerForRegisterDto employerForRegisterDto) {
		var user = new Employer();
		user.setId(employerForRegisterDto.getId());
		user.setCompanyName(employerForRegisterDto.getCompanyName());
		user.setWebAddress(employerForRegisterDto.getWebAddress());
		user.setEmailAddress(employerForRegisterDto.getEmailAddress());
		user.setPassword(employerForRegisterDto.getPassword());

		if (user.getPassword() == employerForRegisterDto.getRepeatPassword()) {
			this.employerService.add(user);
			return new SuccessResult("Kullanıcı başarıyla eklendi.");

		} else {
			return new ErrorResult("Yazdığınız şifreler birbiriyle uyuşmuyor lütfen kontrol ediniz.");
		}

	}

}
