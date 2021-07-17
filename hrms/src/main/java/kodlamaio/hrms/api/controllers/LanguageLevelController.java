package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LanguageLevelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.LanguageLevel;

import kodlamaio.hrms.entities.dtos.LanguageLevelDto;

@RestController
@RequestMapping("/api/languageLevels")
@CrossOrigin
public class LanguageLevelController {
	@Autowired
	private LanguageLevelService languageLevelService;

	@GetMapping("/getAll")
	public DataResult<List<LanguageLevel>> getAll() {
		return this.languageLevelService.getAll();
	}

	@GetMapping("/getLanguageLevelDetails")
	public DataResult<List<LanguageLevelDto>> getLanguageLevelDetails(@RequestParam int cvId) {
		return this.languageLevelService.getLanguageLevelDetails(cvId);
	}
	
	@PostMapping("/updateLanguageLevel")
	public Result updateLanguageLevel(@RequestParam("languageId") int languageId,@RequestParam("levelId") int levelId,@RequestParam("id") int id)
	{
		return this.languageLevelService.languageLevel(languageId, levelId, id);
	}
}
