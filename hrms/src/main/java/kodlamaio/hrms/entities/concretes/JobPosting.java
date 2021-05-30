package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_postings")
@AllArgsConstructor
@NoArgsConstructor

public class JobPosting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "min_salary")
	private int minSalary;
	@Column(name = "max_salary")
	private int maxSalary;
	@Column(name = "open_position")
	private String openPosition;
	@Column(name = "last_date")
	private LocalDate lastDate;
	@Column(name = "status")
	private boolean status;

	@ManyToOne()
	@JoinColumn(name = "jobtitle_id")
	private JobTitle jobTitle;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

}
