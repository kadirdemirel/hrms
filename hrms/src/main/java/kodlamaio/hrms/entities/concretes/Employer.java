package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobPostings", "employerJobTitles" })

public class Employer extends User {

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "web_address")
	private String webAddress;

	@Column(name = "phone")
	private String phone;
	
	@Column(name = "clone_company_name")
	private String companyNameClone;


	@Column(name = "clone_phone")
	private String phoneClone;
	

	@Column(name = "status")
	private boolean status;

	@OneToMany(mappedBy = "employer")
	private List<JobPosting> jobPostings;



}
