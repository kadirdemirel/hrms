package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.abstracts.VerificationEmailService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;
import lombok.var;

@Service
public class EmployerManager implements EmployerService {

	@Autowired
	EmployerDao employerDao;
	@Autowired
	VerificationEmailService verificationEmailService;
	@Autowired
	EmployeService employeService;

	@Override
	public Result add(EmployerForRegisterDto employerForRegisterDto) {
		var employer = new Employer();
		employer.setId(employerForRegisterDto.getId());
		employer.setCompanyName(employerForRegisterDto.getCompanyName());
		employer.setWebAddress(employerForRegisterDto.getWebAddress());
		employer.setEmailAddress(employerForRegisterDto.getEmailAddress());
		employer.setPassword(employerForRegisterDto.getPassword());

		if (employer.getPassword().equals(employerForRegisterDto.getRepeatPassword())) {
			if (employer.getCompanyName() != null && employer.getEmailAddress() != null
					&& employer.getPassword() != null && employer.getWebAddress() != null) {
				this.employerDao.save(employer);
				if (verificationLink()) {
					this.employerDao.save(employer);
					return new SuccessResult("Kullanıcı başarıyla eklendi");
				}

				else if (this.employeService.confirm(employer) != null) {

					this.employerDao.save(employer);
					return new SuccessResult("Kullanıcı başarıyla eklendi");

				} else {
					return new ErrorResult("Kullanıcı doğrulama linkine tıklamadığı için kaydı geçersiz sayıldı.");
				}

			} else {

				return new ErrorResult("Bütün alanların doldurulması zorunludur !");
			}
		} else {
			return new ErrorResult("Yazdığınız şifreler birbiriyle uyuşmuyor lütfen kontrol ediniz.");
		}

	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	private boolean verificationLink() {
		Boolean aBoolean = this.verificationEmailService.verificationEmail("Link kullanıcıya ulaştı.");
		if (!aBoolean) {
			System.out.println("Kullanıcı doğrulama linkine tıkladı.");
			return true;
		} else {

			return false;
		}
	}


}
