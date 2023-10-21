package com.school.school.business.abstracts;

import java.util.List;

import com.school.school.business.requests.CreateSchoolStudentRequest;
import com.school.school.business.responses.GetAllSchoolStudentResponse;
import com.school.school.business.responses.GetByIdSchoolStudentResponse;

public interface SchoolStudentService {
	List<GetAllSchoolStudentResponse>getAllSchoolStudentResponses();
	GetByIdSchoolStudentResponse getByIdSchoolStudentResponse(int id);
	void add(CreateSchoolStudentRequest createSchoolStudentRequest);

}
