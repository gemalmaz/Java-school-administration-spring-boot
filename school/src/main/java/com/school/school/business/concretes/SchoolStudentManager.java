package com.school.school.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.school.school.business.abstracts.SchoolStudentService;
import com.school.school.business.requests.CreateSchoolStudentRequest;
import com.school.school.business.responses.GetAllSchoolStudentResponse;
import com.school.school.business.responses.GetByIdSchoolStudentResponse;
import com.school.school.core.utilities.ModelMapperService;
import com.school.school.dataAccess.abstracts.SchoolStudentRepository;
import com.school.school.entities.concretes.SchoolStudent;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Service
public class SchoolStudentManager implements SchoolStudentService{
	private SchoolStudentRepository schoolStudentRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllSchoolStudentResponse> getAllSchoolStudentResponses() {
		List<SchoolStudent> schoolStudents=schoolStudentRepository.findAll();
		List<GetAllSchoolStudentResponse>getAllSchoolStudentResponses=schoolStudents.stream()
				.map(schoolStudentss->modelMapperService.forResponse().map(schoolStudents, GetAllSchoolStudentResponse.class))
				.collect(Collectors.toList());
		return getAllSchoolStudentResponses;
	}

	@Override
	public GetByIdSchoolStudentResponse getByIdSchoolStudentResponse(int id) {
		SchoolStudent schoolStudent = schoolStudentRepository.findById(id).orElseThrow();
		GetByIdSchoolStudentResponse getByIdSchoolStudentResponse=this.modelMapperService.forResponse()
		.map(schoolStudent, GetByIdSchoolStudentResponse.class);
		return getByIdSchoolStudentResponse;
	}

	@Override
	public void add(CreateSchoolStudentRequest createSchoolStudentRequest) {
		SchoolStudent schoolStudent = modelMapperService.forRequest()
				.map(createSchoolStudentRequest, SchoolStudent.class);
				this.schoolStudentRepository.save(schoolStudent);
				
		
	}
 
}
