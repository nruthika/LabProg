package com.capg.demo.springjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.demo.springjpa.error.TraineeAlreadyExistsException;
import com.capg.demo.springjpa.error.TraineeNotFoundException;
import com.capg.demo.springjpa.model.Trainee;
import com.capg.demo.springjpa.repo.TraineeDataJpaRepo;
import com.capg.demo.springjpa.repo.TraineeJpaRepo;

@Service
public class TraineeService {
	@Autowired
	TraineeJpaRepo repo;
	@Autowired
	TraineeDataJpaRepo dataJpaRepo;
	@Transactional
	public Trainee addTrainee(Trainee trainee) throws TraineeAlreadyExistsException
	{
		//return repo.addTrainee(trainee);
		if(dataJpaRepo.existsById(trainee.getTraineeId()))
		{
			throw new TraineeAlreadyExistsException("Trainee already exists");
		}
		return dataJpaRepo.save(trainee);
	}
	@Transactional
	public Trainee getTrainee(int id) throws TraineeNotFoundException
	{
		//return repo.getTraineeById(id);
		if(!dataJpaRepo.existsById(id))
		{
			throw new TraineeNotFoundException("Trainee with id "+id+" "+"not found");
		}
		return dataJpaRepo.getOne(id);
	}
	@Transactional
	public List<Trainee> getAllTrainees()
	{
		//return repo.getAllTrainees();
		return dataJpaRepo.findAll();
	}
	@Transactional
	public void deleteTrainee(int traineeId) throws TraineeNotFoundException
	{
		if(!dataJpaRepo.existsById(traineeId))
		{
			throw new TraineeNotFoundException("Trainee with id "+traineeId+" "+"not found");
		}
		dataJpaRepo.deleteById(traineeId);
	}
	public Trainee updateTrainee(Trainee trainee) throws TraineeNotFoundException
	{
		
		Trainee tr=dataJpaRepo.getOne(trainee.getTraineeId());
		if(tr==null)
		{
			throw new TraineeNotFoundException("Trainee with not found");
		}
		tr.setTraineeName(trainee.getTraineeName());
		tr.setTraineeLocation(trainee.getTraineeLocation());
		tr.setTraineeDomain(trainee.getTraineeDomain());
	return	dataJpaRepo.save(tr);
		
	}
	public Trainee findByName(String traineeName) throws TraineeNotFoundException
	{
		Trainee tr=dataJpaRepo.findBytraineeName(traineeName);
		if(tr==null)
		{
			throw new TraineeNotFoundException("Trainee with not found");
		}
		return dataJpaRepo.findBytraineeName(traineeName);
	}

	
}
