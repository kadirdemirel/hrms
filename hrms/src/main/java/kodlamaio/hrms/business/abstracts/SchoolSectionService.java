package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.SchoolSection;

import kodlamaio.hrms.entities.dtos.SchoolSectionDto;

public interface SchoolSectionService {
	DataResult<List<SchoolSection>> getAll();

	Result add(SchoolSection scholSection);

	DataResult<List<SchoolSectionDto>> getSchoolSectionDetails(int cvId);
	
	Result  updateSchoolSection(int schoolId,int sectionId,int id);
}
