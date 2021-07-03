package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
	List<JobPosting> getByStatus(int status);

	List<JobPosting> getByStatus(int status, Sort sort);

	List<JobPosting> getByStatusAndEmployerId(int status, int id);

	List<JobPosting> getByCityIdAndTypeOfWorkId(int cityId, int typeOfWorkId);

	JobPosting getById(int id);

	@Modifying
	@Transactional
	@Query("update JobPosting set status=:status where id=:id ")

	int updateStatus(@Param("status") int status, @Param("id") int id);

}
