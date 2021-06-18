package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.TypeOfWorkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.TypeOfWorkDao;
import kodlamaio.hrms.entities.concretes.TypeOfWork;


@Service
public class TypeOfWorkManager implements TypeOfWorkService {

	@Autowired
	private TypeOfWorkDao typeOfWorkDao;

	@Override
	public DataResult<List<TypeOfWork>> getAll() {
	return new SuccessDataResult<List<TypeOfWork>>(this.typeOfWorkDao.findAll());
	}

}
