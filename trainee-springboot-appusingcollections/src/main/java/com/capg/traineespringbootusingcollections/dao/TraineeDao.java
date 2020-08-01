package com.capg.traineespringbootusingcollections.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.capg.traineespringbootusingcollections.model.Trainee;
@Repository
public class TraineeDao {
	Map<Integer,Trainee> traineeMap=new HashMap();
	public Trainee addTrainee(Trainee t1)
	{
		traineeMap.put(t1.getId(), t1);
		
		return t1;
	}
	public boolean removeTrainee(int id)
	{
		if(traineeMap.containsKey(id))
		{
			traineeMap.remove(id);
			return true;
		}
		else
		{
			return false;
		}
	}


}
