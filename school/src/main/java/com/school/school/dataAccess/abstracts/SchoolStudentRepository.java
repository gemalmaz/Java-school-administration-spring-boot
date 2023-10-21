package com.school.school.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.school.entities.concretes.SchoolStudent;

public interface SchoolStudentRepository extends JpaRepository<SchoolStudent, Integer>{

}
