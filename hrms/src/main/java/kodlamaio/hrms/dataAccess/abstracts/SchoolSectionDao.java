package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.SchoolSection;

import kodlamaio.hrms.entities.dtos.SchoolSectionDto;

public interface SchoolSectionDao extends JpaRepository<SchoolSection, Integer> {
	@Query("Select new kodlamaio.hrms.entities.dtos.SchoolSectionDto(ss.id,sc.schoolName, se.sectionName) "
			+ "From SchoolSection ss INNER JOIN ss.school sc INNER JOIN ss.section se " + " where ss.cv.id = ?1")
	List<SchoolSectionDto> getSchoolSectionDto(int cvId);
	
	@Modifying
	@Transactional
	@Query("update SchoolSection set school.id=:schoolId, section.id=:sectionId where id=:id")

	int updateSchoolSection(@Param("schoolId") int schoolId, @Param("sectionId") int sectionId, @Param("id") int id);
}
