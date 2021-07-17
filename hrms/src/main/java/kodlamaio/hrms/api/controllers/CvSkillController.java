package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvSkill;
import kodlamaio.hrms.entities.dtos.CvSkillDto;

@RestController
@RequestMapping("/api/cvsSkill")
@CrossOrigin
public class CvSkillController {
	@Autowired
	private CvSkillService cvSkillService;

	@GetMapping("/getAll")
	public DataResult<List<CvSkill>> getAll() {
		return this.cvSkillService.getAll();
	}

	@GetMapping("/getCvSkillDetails")
	public DataResult<List<CvSkillDto>> getCvSkillDetails(@RequestParam int cvId) {
		return this.cvSkillService.getCvSkillDetails(cvId);
	}

	@PostMapping("/updateCvSkill")
	public Result updateCvSkill(int skillId, int id) {
		return this.cvSkillService.updateCvSkill(skillId, id);
	}
}
