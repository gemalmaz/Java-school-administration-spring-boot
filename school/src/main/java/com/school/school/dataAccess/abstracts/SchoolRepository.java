package com.school.school.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.school.entities.concretes.School;

public interface SchoolRepository extends JpaRepository<School, Integer>{

	boolean existsByname(String name);

	
}
