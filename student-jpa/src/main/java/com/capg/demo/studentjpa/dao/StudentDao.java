package com.capg.demo.studentjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.demo.studentjpa.model.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {

}
