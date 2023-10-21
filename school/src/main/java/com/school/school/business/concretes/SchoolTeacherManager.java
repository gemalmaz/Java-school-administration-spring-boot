package com.school.school.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.school.school.business.abstracts.SchoolTeacherService;
import com.school.school.business.requests.CreateSchoolRequest;
import com.school.school.business.requests.CreateSchoolTeacherRequest;
import com.school.school.business.responses.GetAllSchoolTeacherResponse;
import com.school.school.business.responses.GetByIdSchoolResponse;
import com.school.school.core.utilities.ModelMapperService;
import com.school.school.dataAccess.abstracts.SchoolTeacherRepository;
import com.school.school.entities.concretes.SchoolTeacher;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class SchoolTeacherManager implements SchoolTeacherService{
	private SchoolTeacherRepository schoolTeacherRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllSchoolTeacherResponse> getAllSchoolTeacherResponses() {
		List<SchoolTeacher> schoolTeachers= schoolTeacherRepository.findAll();
		List<GetAllSchoolTeacherResponse>getAllSchoolTeacherResponses=schoolTeachers.stream()
				.map(schoolTeacherss->this.modelMapperService.forResponse().map(schoolTeachers, GetAllSchoolTeacherResponse.class))
				.collect(Collectors.toList());
		return getAllSchoolTeacherResponses;
	}

	@Override
	public GetByIdSchoolResponse getByIdSchoolResponse(int id) {
		SchoolTeacher schoolTeacher = schoolTeacherRepository.findById(id).orElseThrow();
		GetByIdSchoolResponse getByIdSchoolResponse=this.modelMapperService.forResponse()
         .map(schoolTeacher, GetByIdSchoolResponse.class);
				return getByIdSchoolResponse;
	}

	@Override
	public void add(CreateSchoolTeacherRequest CreateSchoolTeacherRequest) {
		SchoolTeacher schoolTeacher = modelMapperService.forRequest()
				.map(CreateSchoolTeacherRequest, SchoolTeacher.class);
						this.schoolTeacherRepository.save(schoolTeacher);
		
	}

	

}
