package com.school.school.core.utilities;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    
	ModelMapper forRequest();
	ModelMapper forResponse();
}
