package com.capg.demo.studentjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.demo.studentjpa.exceptions.StudentAgeException;
import com.capg.demo.studentjpa.exceptions.StudentAlreadyExists;
import com.capg.demo.studentjpa.exceptions.StudentNotFoundException;
import com.capg.demo.studentjpa.model.Student;
import com.capg.demo.studentjpa.service.StudentService;

@RestController
public class StudentController {
@Autowired
StudentService service;
@PostMapping("/student")

public Student addStudent(@RequestBody Student student) throws StudentAlreadyExists, StudentAgeException 
{
	return service.addStudent(student);
}
@GetMapping("/student/id/{id}")
public Student getStudent(@PathVariable int id) throws StudentNotFoundException
{
	return service.getStudent(id);
}
@GetMapping("/students")
public List<Student> getAllStudents()
{
	return service.getAllStudents();
}
@DeleteMapping("/student/id/{id}")
public void deleteTrainee(@PathVariable int id) throws StudentNotFoundException
{
	service.deleteStudent(id);
}
@PutMapping("/student")
public Student updateStudent(@RequestBody Student student) throws StudentNotFoundException
{
return service.updateStudent(student);	

}
}
