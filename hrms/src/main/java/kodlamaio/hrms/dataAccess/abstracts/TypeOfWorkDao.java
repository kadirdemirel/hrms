package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.TypeOfWork;


public interface TypeOfWorkDao extends JpaRepository<TypeOfWork, Integer> {

}
