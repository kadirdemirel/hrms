package kodlamaio.hrms.api.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.Cv;

@RestController
@RequestMapping("/api/cvs")
@CrossOrigin
public class CvController {
	@Autowired
	CvService cvService;

	@PostMapping("/add")
	public Result add(@RequestBody Cv cv) {
		return this.cvService.add(cv);
	}

	@GetMapping("/getall")
	public DataResult<List<Cv>> getAll() {
		return this.cvService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<Cv> getById(int id) {
		return this.cvService.getById(id);
	}

	@PostMapping("/updateCv")
	public Result updateCv(@RequestParam("gitHubAddress") String gitHubAddress,
			@RequestParam("linkedlnAddress") String linkedlnAddress, @RequestParam("coverLetter") String coverLetter,
			String yearOfEntry, String yearOfGraduation, String yearOfEmployment, String yearOff, int id) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");

		// convert String to LocalDate
		// LocalDate localDate = LocalDate.parse(date, formatter);
		return this.cvService.updateCv(gitHubAddress, linkedlnAddress, coverLetter, LocalDate.parse(yearOfEntry),
				LocalDate.parse(yearOfGraduation), LocalDate.parse(yearOfEmployment), LocalDate.parse(yearOff), id);
	}

}
