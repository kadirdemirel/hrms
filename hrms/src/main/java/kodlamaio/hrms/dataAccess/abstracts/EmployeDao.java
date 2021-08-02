package kodlamaio.hrms.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.entities.concretes.Employe;

public interface EmployeDao extends JpaRepository<Employe, Integer> {
	
}
