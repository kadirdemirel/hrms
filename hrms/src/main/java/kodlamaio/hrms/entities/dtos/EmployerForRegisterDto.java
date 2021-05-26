package kodlamaio.hrms.entities.dtos;

import javax.persistence.Column;
import javax.persistence.Entity;

import kodlamaio.hrms.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class EmployerForRegisterDto extends User {

	private String repeatPassword;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "web_address")
	private String webAddress;
}
