package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.MyFavouriteService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.MyFavourite;

@RestController
@RequestMapping("/api/myFavorites")
@CrossOrigin
public class MyFavouriteController {
	@Autowired
	private MyFavouriteService myFavouriteService;
	
	@PostMapping("/add")
	public Result add(@RequestBody MyFavourite myFavourite) {
		return this.myFavouriteService.add(myFavourite);
	}
	@PostMapping("/insertCandidateAndJobPosting")
	
	public Result insertCandidateAndJobPosting(@RequestParam("candidateId") int candidateId, @RequestParam("jobPostingId") int jobPostingId) {

		return this.myFavouriteService.insertCandidateAndJobPosting(candidateId, jobPostingId);

	}
}
