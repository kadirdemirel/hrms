package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SectionService;
import kodlamaio.hrms.core.utilities.results.DataResult;

import kodlamaio.hrms.entities.concretes.Section;

@RestController
@RequestMapping("/api/sections")
@CrossOrigin
public class SectionController {
	@Autowired
	SectionService sectionService;

	@GetMapping("/getall")
	public DataResult<List<Section>> getAll() {
		return this.sectionService.getAll();
	}
}
