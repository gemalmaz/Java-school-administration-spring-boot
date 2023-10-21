package com.school.school.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.school.school.business.requests.CreateSchoolRequest;
import com.school.school.business.requests.DeleteSchoolRequest;
import com.school.school.business.requests.UpdateSchoolRequest;
import com.school.school.business.responses.GetAllSchoolResponse;
import com.school.school.business.responses.GetByIdSchoolResponse;

public interface SchoolService {
	List<GetAllSchoolResponse>getAllSchoolResponses();
	GetByIdSchoolResponse getByIdSchoolResponse(int id);
	void add(CreateSchoolRequest createSchoolRequest);
	void delete(DeleteSchoolRequest deleteSchoolRequest);
	void update(UpdateSchoolRequest updateSchoolRequest);
	

}
