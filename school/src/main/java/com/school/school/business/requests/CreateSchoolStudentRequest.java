package com.school.school.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateSchoolStudentRequest {
	
	

	
	@NotBlank
	@NotNull
	@Size(min = 3 , max = 20)
	private String name;
	private String lastName;
	private String schoolNumber;

	@NotBlank
	@NotNull
private int schoolClassId;
}