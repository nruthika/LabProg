package com.capg.demos.controller;

import com.capg.demos.exception.TraineeNotFound;
import com.capg.demos.model.Trainee;
import com.capg.demos.service.TraineeService;

public class TraineeController {

	TraineeService service;
	
	public void addTrainee(Trainee trainee) {
		service.addTrainee(trainee);
	}
	
	public void deleteTrainee(int id) throws TraineeNotFound {
		service.deleteTrainee(id);
	}
	
	public Trainee getTrainee(int id) throws TraineeNotFound {
		return service.getTrainee(id);
	}
	
	
}
