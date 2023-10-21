package com.school.school.business.rules;

import org.springframework.stereotype.Service;

import com.school.school.business.requests.CreateSchoolRequest;
import com.school.school.business.rules.abstracts.SchoolRulesService;
import com.school.school.core.utilities.exception.BusinessException;
import com.school.school.dataAccess.abstracts.SchoolRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Service
public class SchoolBusinessRules implements SchoolRulesService {
	private SchoolRepository schoolRepository;
	

	


@Override
public void checkIfSchoolBlankAndNull(CreateSchoolRequest createSchoolRequest) {
	if(createSchoolRequest.getName().isBlank() || createSchoolRequest.getName().isEmpty()) {
		throw new BusinessException("School name cannot be left blank");
	}
	

}

@Override
public void checkIfSchoolNameExists(String name) {
	if(this.schoolRepository.existsByname(name)) {
		throw new BusinessException("already exist School name ");
		
	}
}
}
