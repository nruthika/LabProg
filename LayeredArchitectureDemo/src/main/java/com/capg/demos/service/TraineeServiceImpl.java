package com.capg.demos.service;

import com.capg.demos.dao.TraineeDao;
import com.capg.demos.dao.TraineeDaoCollectionsBasedImpl;
import com.capg.demos.exception.TraineeNotFound;
import com.capg.demos.model.Trainee;

public class TraineeServiceImpl implements TraineeService {
	
	TraineeDao dao;
	public TraineeServiceImpl() {
		dao=new TraineeDaoCollectionsBasedImpl();
	}

	@Override
	public void addTrainee(Trainee trainee) {
		dao.addTrainee(trainee);
		
	}

	@Override
	public void deleteTrainee(int id) throws TraineeNotFound {
		// TODO Auto-generated method stub
		Trainee t = dao.findTrainee(id);
		if(t != null) {
			dao.removeTrainee(id);
		}
		else throw new TraineeNotFound("Invalid Trainee id");
		
	}

	@Override
	public Trainee getTrainee(int id) throws TraineeNotFound {
		// TODO Auto-generated method stub
		Trainee t = dao.findTrainee(id);
		if(t != null) {
			return t;
		}
		else throw new TraineeNotFound("Invalid Trainee id");
	}

}
