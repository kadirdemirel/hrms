package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.LanguageLevel;
import kodlamaio.hrms.entities.dtos.LanguageLevelDto;

public interface LanguageLevelDao extends JpaRepository<LanguageLevel, Integer> {

	@Query("Select new kodlamaio.hrms.entities.dtos.LanguageLevelDto(l.id,la.languageName, le.levelName) "
			+ "From LanguageLevel l INNER JOIN l.language la INNER JOIN l.level le " + " where l.cv.id = ?1")
	List<LanguageLevelDto> getLanguageLevelDto(int cvId);
	
	@Modifying
	@Transactional
	@Query("update LanguageLevel set language.id=:languageId, level.id=:levelId where id=:id")

	int languageLevel(@Param("languageId") int languageId, @Param("levelId") int levelId, @Param("id") int id);
}
