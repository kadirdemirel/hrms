package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
	List<JobPosting> getByStatus(boolean status);

	List<JobPosting> getByStatus(boolean status, Sort sort);

	List<JobPosting> getByStatusAndEmployerId(boolean status, int employerId);

}
