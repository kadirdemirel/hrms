package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employe;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployeService {
	Result confirm(Employer employer);

	Result add(Employe employe);
}
