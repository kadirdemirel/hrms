package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SchoolSectionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SchoolSection;

import kodlamaio.hrms.entities.dtos.SchoolSectionDto;

@RestController
@RequestMapping("/api/schoolSections")
@CrossOrigin
public class SchoolSectionController {
	@Autowired
	private SchoolSectionService schoolSectionService;

	@GetMapping("/getAll")
	public DataResult<List<SchoolSection>> getAll() {
		return this.schoolSectionService.getAll();
	}

	@GetMapping("/getSchoolSectionDetails")
	public DataResult<List<SchoolSectionDto>> getSchoolSectionDetails(@RequestParam int cvId) {
		return this.schoolSectionService.getSchoolSectionDetails(cvId);
	}

	@PostMapping("/updateSchoolSection")
	public Result updateSchoolSection(@RequestParam("schoolId") int schoolId, @RequestParam("sectionId") int sectionId,
			@RequestParam("id") int id) {
		
		return this.schoolSectionService.updateSchoolSection(schoolId, sectionId, id);
	}
}
