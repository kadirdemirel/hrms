package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.Image;

@EnableJpaRepositories
public interface ImageDao extends JpaRepository<Image, Integer> {
	List<Image> getAllByCvId(int cvId);

//	@Modifying
//	@Transactional
//	@Query("update Image set url=:url  where id=:id")
//
//	int imageUpdate(@Param("url") String url, @Param("id") int id);
}
