package com.capg.demos.dao;

import java.util.HashMap;
import java.util.Map;

import com.capg.demos.model.Trainee;

public class TraineeDaoCollectionsBasedImpl implements TraineeDao {

	Map<Integer,Trainee> traineeData = new HashMap<Integer,Trainee>();
	@Override
	public void addTrainee(Trainee trainee) {
		// TODO Auto-generated method stub
		traineeData.put(trainee.getId(),trainee);
	}

	@Override
	public Trainee findTrainee(int id) {
		// TODO Auto-generated method stub
		return traineeData.get(id);
		
	}

	@Override
	public void removeTrainee(int id) {
		// TODO Auto-generated method stub
		traineeData.remove(id);
		
	}

}
