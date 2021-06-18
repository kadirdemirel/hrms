package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "images")
@AllArgsConstructor
@NoArgsConstructor
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "url")
	private String url;

	@Column(name = "uploaded_date")
	private LocalDate uploadedDate;
	// private LocalDateTime uploadedDate=LocalDateTime.now(); //"2 Ekim 2007,
	// 13:45.30.123456789"

	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "cv_id")
	private Cv cv;

}
