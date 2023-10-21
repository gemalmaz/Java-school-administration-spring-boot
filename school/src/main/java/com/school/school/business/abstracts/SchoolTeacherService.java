package com.school.school.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.school.school.business.requests.CreateSchoolRequest;
import com.school.school.business.requests.CreateSchoolTeacherRequest;
import com.school.school.business.responses.GetAllSchoolTeacherResponse;
import com.school.school.business.responses.GetByIdSchoolResponse;
public interface SchoolTeacherService {
	List<GetAllSchoolTeacherResponse> getAllSchoolTeacherResponses();
	GetByIdSchoolResponse getByIdSchoolResponse(int id);
	void add(CreateSchoolTeacherRequest	 CreateSchoolTeacherRequest);

}
