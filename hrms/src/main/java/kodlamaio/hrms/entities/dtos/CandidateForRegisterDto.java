package kodlamaio.hrms.entities.dtos;



import javax.persistence.Column;


import kodlamaio.hrms.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateForRegisterDto extends User {

	private String repeatPassword;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "identification_number")
	private String identificationNumber;

	@Column(name = "birth_date")
	private String birthDate;

}
