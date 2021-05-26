package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCheckService;
import kodlamaio.hrms.business.abstracts.CandidateService;

import kodlamaio.hrms.core.abstracts.VerificationEmailService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;

import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {
	@Autowired
	CandidateDao candidateDao;
	@Autowired
	CandidateCheckService candidateCheckService;
	@Autowired
	VerificationEmailService verificationEmailService;

	@Override
	public Result add(Candidate candidate) {

		if (mandatoryField(candidate)) {
			if (identificationNumberAndEmail(candidate)) {

				if (this.candidateCheckService.CheckIfRealPerson(candidate)) {

					if (verificationLink()) {
						this.candidateDao.save(candidate);

					} else {
						return new ErrorResult("Kullanıcı doğrulama linkine tıklamadığı için kayıt başarısız !");
					}

				}
			} else {
				return new ErrorResult("Email veya TC Kimlik numaranız sistemde zaten kayıtlı !");
			}
		} else {
			return new ErrorResult("Hiç bir alan boş geçilemez !");
		}
		return null;

	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}

	private boolean verificationLink() {
		Boolean aBoolean = this.verificationEmailService.verificationEmail("Link kullanıcıya ulaştı.");
		if (aBoolean) {
			System.out.println("Kullanıcı doğrulama linkine tıkladı.");
			return true;
		} else {

			return false;
		}
	}

	private boolean mandatoryField(Candidate candidate) {
		if (candidate.getBirthDate() != null && candidate.getEmailAddress() != "" && candidate.getFirstName() != ""
				&& candidate.getLastName() != "" && candidate.getPassword() != "") {
			return true;
		} else {

			return false;
		}
	}

	private boolean identificationNumberAndEmail(Candidate candidate) {
		for (Candidate emailcheck : this.candidateDao.findAll()) {
			if (emailcheck.getIdentificationNumber().equals(candidate.getIdentificationNumber())
					|| emailcheck.getEmailAddress().equals(candidate.getEmailAddress())) {

				return false;

			} else {
				return true;
			}

		}
		return false;
	}

}
