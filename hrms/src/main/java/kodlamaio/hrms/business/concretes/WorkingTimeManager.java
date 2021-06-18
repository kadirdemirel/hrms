package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkingTimeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkingTimeDao;
import kodlamaio.hrms.entities.concretes.WorkingTime;

@Service
public class WorkingTimeManager implements WorkingTimeService {
	@Autowired
	private WorkingTimeDao workingTimeDao;

	@Override
	public DataResult<List<WorkingTime>> getAll() {
		return new SuccessDataResult<List<WorkingTime>>(this.workingTimeDao.findAll());
	}
}
