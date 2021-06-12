package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cvs")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "schoolSections", "languageLevels",
		"employerJobTitles" })
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
	private List<CvSkill> cvSkills;

	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	@Nullable
	@JsonIgnore
	@OneToOne(mappedBy = "cv", optional = true, fetch = FetchType.LAZY)
	private Image image;

}
