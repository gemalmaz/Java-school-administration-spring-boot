package com.school.school.business.rules.abstracts;

import com.school.school.business.requests.CreateSchoolRequest;

public interface SchoolRulesService {
 void checkIfSchoolBlankAndNull(CreateSchoolRequest createSchoolRequest);
 void checkIfSchoolNameExists(String name);
  
}
