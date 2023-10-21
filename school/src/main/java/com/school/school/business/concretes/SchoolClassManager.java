package com.school.school.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.school.school.business.abstracts.SchoolClassService;
import com.school.school.business.requests.CreateSchoolClassRequest;
import com.school.school.business.responses.GetAllSchoolClassResponse;
import com.school.school.business.responses.GetByIdSchoolClassResponse;
import com.school.school.core.utilities.ModelMapperService;
import com.school.school.dataAccess.abstracts.SchoolClassRepository;
import com.school.school.entities.concretes.SchoolClass;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SchoolClassManager implements SchoolClassService{
	private SchoolClassRepository schoolClassRepository;
	private ModelMapperService modelMapperService;
	
	
	@Override
	public List<GetAllSchoolClassResponse> getAllSchoolClassResponses() {
		List<SchoolClass> schoolClasses=schoolClassRepository.findAll();
		List<GetAllSchoolClassResponse>allSchoolClassResponses=schoolClasses.stream()
				.map(schoolClassess->modelMapperService.forResponse().map(schoolClasses, GetAllSchoolClassResponse.class))
				.collect(Collectors.toList());
		return allSchoolClassResponses;
	}

	@Override
	public GetByIdSchoolClassResponse getByIdSchoolClassResponse(int id) {
		SchoolClass schoolClass = schoolClassRepository.findById(id).orElseThrow();
		GetByIdSchoolClassResponse getByIdSchoolClassResponse=this.modelMapperService.forResponse()
				.map(schoolClass, GetByIdSchoolClassResponse.class);
		return getByIdSchoolClassResponse;
	}

	@Override
	public void add(CreateSchoolClassRequest createSchoolClassRequest) {
		SchoolClass schoolClass = modelMapperService.forRequest()
				.map(createSchoolClassRequest, SchoolClass.class);
		this.schoolClassRepository.save(schoolClass);
		
	}

}
