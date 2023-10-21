package com.school.school.webApi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.school.school.business.abstracts.SchoolService;
import com.school.school.business.requests.CreateSchoolRequest;
import com.school.school.business.requests.DeleteSchoolRequest;
import com.school.school.business.requests.UpdateSchoolRequest;
import com.school.school.business.responses.GetByIdSchoolResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/school")

public class SchoolController {
	private SchoolService schoolService;
@Autowired
	public SchoolController(SchoolService schoolService) {
		
		this.schoolService = schoolService;
	}
	@GetMapping("{id}")
	public GetByIdSchoolResponse getByIdSchoolResponse(@PathVariable int id) {
		return schoolService.getByIdSchoolResponse(id);
		
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus. CREATED)
	void add(CreateSchoolRequest createSchoolRequest) {
		this.schoolService.add(createSchoolRequest);
	}
	@PutMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	void update(@RequestBody UpdateSchoolRequest updateSchoolRequest) {
		this.schoolService.update(updateSchoolRequest);
	}
	@DeleteMapping("{id}")
	
	void delete(DeleteSchoolRequest deleteSchoolRequest) {
		this.schoolService.delete(deleteSchoolRequest);
	}
	
}
