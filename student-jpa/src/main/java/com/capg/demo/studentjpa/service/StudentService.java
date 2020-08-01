package com.capg.demo.studentjpa.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.demo.studentjpa.dao.StudentDao;
import com.capg.demo.studentjpa.exceptions.StudentAgeException;
import com.capg.demo.studentjpa.exceptions.StudentAlreadyExists;
import com.capg.demo.studentjpa.exceptions.StudentNotFoundException;
import com.capg.demo.studentjpa.model.Student;

@Service
public class StudentService {
@Autowired
StudentDao dao;

public Student addStudent(Student student) throws StudentAlreadyExists, StudentAgeException
{
	LocalDate date1 = LocalDate.now();
	Period intervalPeriod = Period.between(student.getDateOfBirth(), date1);
	
	if(intervalPeriod.getYears()<18)
	{
		throw new StudentAgeException("Age should be greater than 18");
	}
	boolean s=dao.existsById(student.getId());
	if(s)
	{
		throw new StudentAlreadyExists("Student already exists please enter valid id");
	}
			
	return dao.save(student);
}
public Student getStudent(int id) throws StudentNotFoundException
{
	if(dao.getOne(id)==null)
	{
		throw new StudentNotFoundException("Student with id "+id+" doesnot exist");
	}
	return dao.getOne(id);
}
public List<Student> getAllStudents()
{
	return dao.findAll();
}
public void deleteStudent(int id) throws StudentNotFoundException
{
	if(dao.existsById(id))
	{
dao.deleteById(id);	
	}
	else
	{
		throw new StudentNotFoundException("Student doesnot exist");
	}
}
public Student updateStudent(Student student) throws StudentNotFoundException
{
	
	if(dao.existsById(student.getId()))
	{
		Student s = dao.getOne(student.getId());
		s.setDateOfBirth(student.getDateOfBirth());
		//s.setId(s.getId());
		s.setName(student.getName());
		return dao.save(s);			
	}
	else
	{
		throw new StudentNotFoundException("Student doesnot exist");
	}
}
}
