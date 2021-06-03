package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cvs")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "schoolSections", "languageLevels", "employerJobTitles",
		"images" })
public class Cv {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "github_address")
	private String gitHubAddress;

	@Column(name = "linkedln_address")
	private String linkedlnAddress;

	@Column(name = "cover_letter")
	private String coverLetter;

	@Column(name = "year_of_entry")
	private LocalDate yearOfEntry;
	@Column(name = "year_of_graduation")
	private LocalDate yearOfGraduation;

	@Column(name = "year_of_employment")
	private LocalDate yearOfEmployment;

	@Column(name = "year_off")
	private LocalDate yearOff;

	@OneToMany(mappedBy = "cv")
	private List<LanguageLevel> languageLevels;

	@OneToMany(mappedBy = "cv")
	private List<SchoolSection> schoolSections;

	@OneToMany(mappedBy = "cv")
	private List<EmployerJobTitle> employerJobTitles;

	@OneToMany(mappedBy = "cv")
	private List<Image> images;

	@OneToMany(mappedBy = "cv")
	private List<CvSkill> cvSkills;

}
