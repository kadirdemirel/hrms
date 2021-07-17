package kodlamaio.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.Cv;

public interface CvService {
	DataResult<List<Cv>> getByYearOfGraduation(Cv cv);

	DataResult<List<Cv>> getByYearOff(Cv cv);

	Result add(Cv cv);

	DataResult<List<Cv>> getAll();

	DataResult<Cv> getById(int id);

	Result updateCv(String gitHubAddress, String linkedlnAddress, String coverLetter, LocalDate yearOfEntry,
			LocalDate yearOfGraduation, LocalDate yearOfEmployment, LocalDate yearOff, int id);
}
