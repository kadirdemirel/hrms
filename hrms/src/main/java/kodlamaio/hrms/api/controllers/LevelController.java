package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LevelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Level;

@RestController
@RequestMapping("/api/levels")
@CrossOrigin
public class LevelController {
	@Autowired
	LevelService levelService;

	@GetMapping("/getall")
	public DataResult<List<Level>> getAll() {
		return this.levelService.getAll();
	}
}
