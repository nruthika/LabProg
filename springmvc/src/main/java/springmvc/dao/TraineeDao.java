package springmvc.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.capg.model.Trainee;

@Repository
public class TraineeDao {
Map<Integer,Trainee> traineeMap=new HashMap<>();
	public Trainee addTrainee(Trainee t1)
	{	
	traineeMap.put(t1.getId(),t1);
	return t1;
	}
	public Trainee fetchTrainee(int id)
	{
		return traineeMap.get(id);
	}

}
