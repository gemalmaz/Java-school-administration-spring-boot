package com.school.school.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSchoolTeacherRequest {

	@NotNull
	@NotBlank
	@Size(min = 3 , max = 10)
	private String name;
	
	@NotNull
	@NotBlank
	private int schoolId;
}
