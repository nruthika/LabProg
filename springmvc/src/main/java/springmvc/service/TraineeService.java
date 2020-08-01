package springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.model.Trainee;

import springmvc.dao.TraineeDao;

@Service
public class TraineeService {
@Autowired
TraineeDao dao;

	public Trainee addTrainee(Trainee t1)
	{
	
		return dao.addTrainee(t1);
	}
	public Trainee getTrainee(int id)
	{
		return dao.fetchTrainee(id);
	}


}
