package kodlamaio.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.Cv;

public interface CvDao extends JpaRepository<Cv, Integer> {
	List<Cv> getByYearOfGraduation(LocalDate yearOfGraduation, Sort sort);

	List<Cv> getByYearOff(LocalDate yearOff, Sort sort);

	Cv getById(int id);

	@Modifying
	@Transactional
	@Query("update Cv set gitHubAddress=:gitHubAddress,linkedlnAddress=:linkedlnAddress,coverLetter=:coverLetter,yearOfEntry=:yearOfEntry,yearOfGraduation=:yearOfGraduation,yearOfEmployment=:yearOfEmployment,yearOff=:yearOff where id=:id")

	int updateCv(@Param("gitHubAddress") String gitHubAddress, @Param("linkedlnAddress") String linkedlnAddress,
			@Param("coverLetter") String coverLetter, LocalDate yearOfEntry, LocalDate yearOfGraduation,
			LocalDate yearOfEmployment, LocalDate yearOff, @Param("id") int id);
}
