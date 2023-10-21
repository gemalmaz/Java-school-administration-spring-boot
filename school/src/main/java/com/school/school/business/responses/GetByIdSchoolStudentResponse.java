package com.school.school.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetByIdSchoolStudentResponse {
private int id;
	
	
	private String name;
	private String lastName;
	private String schoolNumber;
}
