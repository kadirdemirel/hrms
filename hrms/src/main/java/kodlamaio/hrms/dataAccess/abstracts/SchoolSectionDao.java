package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.SchoolSection;

import kodlamaio.hrms.entities.dtos.SchoolSectionDto;

public interface SchoolSectionDao extends JpaRepository<SchoolSection, Integer> {
	@Query("Select new kodlamaio.hrms.entities.dtos.SchoolSectionDto(ss.id,sc.schoolName, se.sectionName) "
			+ "From SchoolSection ss INNER JOIN ss.school sc INNER JOIN ss.section se " + " where ss.cv.id = ?1")
	List<SchoolSectionDto> getSchoolSectionDto(int cvId);
}
