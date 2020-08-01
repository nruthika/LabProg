package com.capg.demo.springjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capg.demo.springjpa.error.TraineeAlreadyExistsException;
import com.capg.demo.springjpa.error.TraineeNotFoundException;
import com.capg.demo.springjpa.model.Trainee;
import com.capg.demo.springjpa.service.TraineeService;

@RestController
public class TraineeController {
	@Autowired
	TraineeService service;
	
	@PostMapping("/trainees")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Trainee addTrainee(@RequestBody Trainee trainee) throws TraineeAlreadyExistsException 
	{
		
			return service.addTrainee(trainee);
		
	}
	@GetMapping("/trainees/id/{id}")
	public Trainee addTrainee(@PathVariable int id) 
	{
		
		try {
			return service.getTrainee(id);
		} catch (TraineeNotFoundException e) {
			// TODO Auto-generated catch block
		
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}
	@GetMapping("/trainees")
	public List<Trainee> getAllTrainees()
	{
		return service.getAllTrainees();
	}
	@DeleteMapping("/trainees/id/{id}")
	public void deleteTrainee(@PathVariable int id) throws TraineeNotFoundException
	{
		service.deleteTrainee(id);
	}
	@PutMapping("/trainees")
	public Trainee updateTrainee(@RequestBody Trainee trainee) throws TraineeNotFoundException
	{
		return service.updateTrainee(trainee);
	}
	@GetMapping("/trainee/traineeName/{traineeName}")
	public Trainee findTrainee(@PathVariable String traineeName) throws TraineeNotFoundException
	{
		return service.findByName(traineeName);
	}
}
