package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;
import lombok.var;

@Service
public class UserManager implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public Result GetByMail(String email) {
		var resultVar = this.userDao.findAll();
		for (User users : resultVar) {
			if (users.getEmailAddress() == email) {
				return new ErrorResult("Bu email kullanılıyor");
			} else {
				return new SuccessResult();
			}

		}
		return null;
	}
}