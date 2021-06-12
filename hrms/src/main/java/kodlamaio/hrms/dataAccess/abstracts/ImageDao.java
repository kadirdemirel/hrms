package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import kodlamaio.hrms.entities.concretes.Image;



@EnableJpaRepositories
public interface ImageDao extends JpaRepository<Image, Integer> {
	List<Image> getAllByCvId(int cvId);
	

}
