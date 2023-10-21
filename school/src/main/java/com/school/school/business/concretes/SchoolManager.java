package com.school.school.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.school.school.business.abstracts.SchoolService;
import com.school.school.business.requests.CreateSchoolRequest;
import com.school.school.business.requests.DeleteSchoolRequest;
import com.school.school.business.requests.UpdateSchoolRequest;
import com.school.school.business.responses.GetAllSchoolResponse;
import com.school.school.business.responses.GetByIdSchoolResponse;
import com.school.school.business.rules.SchoolBusinessRules;
import com.school.school.core.utilities.ModelMapperService;
import com.school.school.core.utilities.exception.BusinessException;
import com.school.school.dataAccess.abstracts.SchoolRepository;
import com.school.school.entities.concretes.School;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SchoolManager implements SchoolService{
	private ModelMapperService mapperService;
	private SchoolRepository schoolRepository;
	private SchoolBusinessRules schoolBusinessRules;
	
	
	@Override
	public List<GetAllSchoolResponse> getAllSchoolResponses() {
		List<School> schools= schoolRepository.findAll();
		List<GetAllSchoolResponse>getAllSchoolResponses=schools.stream()
				.map(school->this.mapperService.forResponse().map(schools, GetAllSchoolResponse.class))
				.collect(Collectors.toList());
		return getAllSchoolResponses;
	}

	@Override
	public GetByIdSchoolResponse getByIdSchoolResponse(int id) {
		School school = schoolRepository.findById(id).orElseThrow();
		GetByIdSchoolResponse getByIdSchoolResponse=this.mapperService.forResponse()
       .map(school, GetByIdSchoolResponse.class);
				return getByIdSchoolResponse;
	}

	@Override
	public void add(CreateSchoolRequest createSchoolRequest) {
		this.schoolBusinessRules.checkIfSchoolNameExists(createSchoolRequest.getName());
		this.schoolBusinessRules.checkIfSchoolBlankAndNull(createSchoolRequest);
		School school = this.mapperService.forRequest().map(createSchoolRequest, School.class);
				this.schoolRepository.save(school);
		
	}



	@Override
	public void update(UpdateSchoolRequest updateSchoolRequest) {
		
		School school = this.mapperService.forRequest().map(updateSchoolRequest, School.class);
		this.schoolRepository.save(school);
		
	}

	@Override
	public void delete(DeleteSchoolRequest deleteSchoolRequest) {
		School school = new School();
		school.setId(deleteSchoolRequest.getId());
		schoolRepository.delete(school);
		
	}

}
