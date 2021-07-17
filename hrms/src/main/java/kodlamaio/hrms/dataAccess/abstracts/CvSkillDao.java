package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.CvSkill;
import kodlamaio.hrms.entities.dtos.CvSkillDto;

public interface CvSkillDao extends JpaRepository<CvSkill, Integer> {

	@Query("Select new kodlamaio.hrms.entities.dtos.CvSkillDto(c.id, " + " s.skillName) "
			+ "From CvSkill c INNER JOIN c.skill s " + " where c.cv.id = ?1")
	List<CvSkillDto> getCvSkillDto(int cvId);

	@Modifying
	@Transactional
	@Query("update CvSkill set skill.id=:sckillId where id=:id")

	int updateCvSkill(@Param("sckillId") int sckillId, @Param("id") int id);
}
