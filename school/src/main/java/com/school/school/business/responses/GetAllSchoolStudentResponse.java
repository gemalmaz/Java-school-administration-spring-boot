package com.school.school.business.responses;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class GetAllSchoolStudentResponse {
private int id;
	
	
	private String name;
	private String lastName;
	private String schoolNumber;
}
