package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateWithCvDto {

	private int id;
	private String gitHubAddress;
	private String linkedlnAddress;
	private String coverLetter;
	private LocalDate yearOfEntry;
	private LocalDate yearOfGraduation;
	private LocalDate yearOfEmployment;
	private LocalDate yearOff;
	private String languageName;
	private String levelName;
	private String schoolName;
	private String sectionName;
	private String skillName;
	private String firstName;
	private String lastName;
	private String url;
}
