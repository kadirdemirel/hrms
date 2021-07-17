package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.PageableDto;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
	List<JobPosting> getByStatus(int status);

	List<JobPosting> getByStatus(int status, Sort sort);

	List<JobPosting> getByStatusAndEmployerId(int status, int id);

//	List<JobPosting> getByCityIdAndTypeOfWorkId(int cityId, int typeOfWorkId);
//	List<PageableDto<List<JobPosting>>> getByCityIdAndTypeOfWorkId(int cityId,int typeOfWorkId);

	JobPosting getById(int id);

	@Modifying
	@Transactional
	@Query("update JobPosting set status=:status where id=:id ")

	int updateStatus(@Param("status") int status, @Param("id") int id);

	@Query("Select j from kodlamaio.hrms.entities.concretes.JobPosting j where"
			+ " ((:#{#filter.cityId}) IS 0 OR j.city.id IN (:#{#filter.cityId}))"
			+ " and ((:#{#filter.typeOfWorkId}) IS 0 OR j.typeOfWork.id IN (:#{#filter.typeOfWorkId}))"
			+ " and j.status=1")
	public Page<JobPosting> getByFilter(@Param("filter") PageableDto pageableDto, Pageable pageable);

}
