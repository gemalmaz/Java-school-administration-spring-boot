package com.school.school.webApi.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.school.school.business.abstracts.SchoolClassService;
import com.school.school.business.requests.CreateSchoolClassRequest;
import com.school.school.business.responses.GetByIdSchoolClassResponse;

@RequestMapping("api/class")
@RestController
public class SchoolClassController {
	private SchoolClassService schoolClassService;

	public SchoolClassController(SchoolClassService schoolClassService) {
		
		this.schoolClassService = schoolClassService;
	}
	@GetMapping("{id}")
	GetByIdSchoolClassResponse getByIdSchoolClassResponse(@PathVariable int id) {
		return schoolClassService.getByIdSchoolClassResponse(id);
	}
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	void add(@RequestBody CreateSchoolClassRequest createSchoolClassRequest) {
		this.schoolClassService.add(createSchoolClassRequest);
	}
	

}
