package kodlamaio.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.entities.concretes.Cv;


public interface CvDao extends JpaRepository<Cv, Integer> {
	List<Cv> getByYearOfGraduation(LocalDate yearOfGraduation, Sort sort);

	List<Cv> getByYearOff(LocalDate yearOff, Sort sort);

}
