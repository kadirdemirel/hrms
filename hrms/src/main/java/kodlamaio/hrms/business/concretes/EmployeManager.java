package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeDao;
import kodlamaio.hrms.entities.concretes.Employe;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployeManager implements EmployeService {

	@Autowired
	EmployeDao employeDao;

	@Override
	public Result confirm(Employer employer) {

		return new SuccessResult("Sistem çalışanı tarafından" + employer.getCompanyName() + " adlı firma doğrulandı.");
	}

	@Override
	public Result add(Employe employe) {
		this.employeDao.save(employe);
		return new SuccessResult("Kullanıcı başarıyla eklendi");

	}

}
