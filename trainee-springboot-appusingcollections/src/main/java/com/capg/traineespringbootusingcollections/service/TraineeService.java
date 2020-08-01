package com.capg.traineespringbootusingcollections.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.traineespringbootusingcollections.dao.TraineeDao;
import com.capg.traineespringbootusingcollections.model.Trainee;
@Service
public class TraineeService {
@Autowired
TraineeDao dao;
public Trainee addTrainee(Trainee t1)
{
return dao.addTrainee(t1)	;
}
public boolean removeTrainee(int id)
{
return dao.removeTrainee(id)	;
}
}
