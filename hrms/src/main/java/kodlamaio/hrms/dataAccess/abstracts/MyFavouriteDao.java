package kodlamaio.hrms.dataAccess.abstracts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.MyFavourite;

public interface MyFavouriteDao extends JpaRepository<MyFavourite, Integer> {
	@Modifying
	@Transactional
	@Query(value = "insert into my_favorites (candidate_id,job_posting_id) values (:candidate_id,:job_posting_id)", nativeQuery = true)
	void insertCandidateAndJobPosting(@Param("candidate_id") int candidate_id,
			@Param("job_posting_id") int job_posting_id);

}
