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
public class CreateSchoolClassRequest {
	@NotBlank
	@NotNull
	@Size(min = 2 , max = 3)
private String name;
	@NotNull
	@NotBlank
	private int schoolId;

}
