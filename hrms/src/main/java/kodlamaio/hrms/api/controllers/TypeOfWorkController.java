package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.TypeOfWorkService;
import kodlamaio.hrms.core.utilities.results.DataResult;

import kodlamaio.hrms.entities.concretes.TypeOfWork;

@RestController
@RequestMapping("/api/typeOfWorks")
@CrossOrigin
public class TypeOfWorkController {
	@Autowired
	private TypeOfWorkService typeOfWorkService;

	@GetMapping("/getall")
	public DataResult<List<TypeOfWork>> getAll() {
		return this.typeOfWorkService.getAll();
	}
}
