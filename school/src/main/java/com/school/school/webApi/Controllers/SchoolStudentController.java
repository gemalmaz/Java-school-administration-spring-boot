package com.school.school.webApi.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.school.school.business.abstracts.SchoolStudentService;
import com.school.school.business.requests.CreateSchoolStudentRequest;
import com.school.school.business.responses.GetByIdSchoolStudentResponse;
@RestController
@RequestMapping("api/student")
public class SchoolStudentController {
	private SchoolStudentService schoolStudentService;

	public SchoolStudentController(SchoolStudentService schoolStudentService) {
		
		this.schoolStudentService = schoolStudentService;
	}
 @GetMapping("{id}")
   GetByIdSchoolStudentResponse getByIdSchoolStudentResponse(@PathVariable int id) {
	 return schoolStudentService.getByIdSchoolStudentResponse(id);
 }
 @PostMapping
 @ResponseStatus(code = HttpStatus.CREATED )
 void add(@RequestBody CreateSchoolStudentRequest createSchoolStudentRequest) {
	 this.schoolStudentService.add(createSchoolStudentRequest);
 }
}
