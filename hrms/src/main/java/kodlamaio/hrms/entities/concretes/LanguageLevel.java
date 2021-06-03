package kodlamaio.hrms.entities.concretes;

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
@Table(name = "language_levels")
@AllArgsConstructor
@NoArgsConstructor

public class LanguageLevel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne()
	@JoinColumn(name = "language_id")
	private Language language;

	@ManyToOne()
	@JoinColumn(name = "level_id")
	private Level level;

	@ManyToOne()
	@JoinColumn(name = "cv_id")
	private Cv cv;

}
