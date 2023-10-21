package com.school.school.business.abstracts;

import java.util.List;

import com.school.school.business.requests.CreateSchoolClassRequest;
import com.school.school.business.responses.GetAllSchoolClassResponse;
import com.school.school.business.responses.GetAllSchoolTeacherResponse;
import com.school.school.business.responses.GetByIdSchoolClassResponse;

public interface SchoolClassService {
	List<GetAllSchoolClassResponse>getAllSchoolClassResponses();
	GetByIdSchoolClassResponse getByIdSchoolClassResponse(int id);
	void add(CreateSchoolClassRequest createSchoolClassRequest);

}
