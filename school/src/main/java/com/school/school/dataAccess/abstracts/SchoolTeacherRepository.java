package com.school.school.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.school.entities.concretes.SchoolTeacher;

public interface SchoolTeacherRepository extends JpaRepository<SchoolTeacher, Integer>{

}
