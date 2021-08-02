package kodlamaio.hrms.dataAccess.abstracts;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	
	Employer getById(int id);
	
	
	@Modifying
	@Transactional
	@Query("update Employer set companyName=:companyName,phone=:phone,status=:status  where id=:id")

	int updateEmployer(@Param("companyName") String companyName,@Param("phone") String phone,@Param("status") boolean status, @Param("id") int id);
	
	@Modifying
	@Transactional
	@Query("update Employer set companyNameClone=:companyNameClone, phoneClone=:phoneClone,status=:status where id=:id")

	int updateEmployerClone(@Param("companyNameClone") String companyNameClone, @Param("phoneClone") String phoneClone,@Param("status") boolean status, @Param("id") int id);
}
