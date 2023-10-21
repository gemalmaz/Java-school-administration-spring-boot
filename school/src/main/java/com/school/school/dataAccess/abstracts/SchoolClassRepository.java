package com.school.school.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.school.entities.concretes.SchoolClass;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Integer>{

}
