package com.capg.demo.springjpa.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capg.demo.springjpa.model.Trainee;

@Repository
public class TraineeJpaRepo {
	@PersistenceContext
	EntityManager em;
	public Trainee addTrainee(Trainee trainee)
	{
		Trainee tr=em.find(Trainee.class, trainee.getTraineeId());
		if(tr==null)
		{
			return em.merge(trainee);
		}
		else {
			throw new RuntimeException("Trainee already exists");
		}
		
	}
	public Trainee getTraineeById(int id)
	{
		return em.find(Trainee.class, id);
	}
	public List<Trainee> getAllTrainees()
	{
		Query qr=em.createQuery("from Trainee");
		return qr.getResultList();
	}
	public void deleteTraineeById(int traineeId)
	{
		Trainee tr=em.find(Trainee.class, traineeId);
		if(tr!=null)
		{
			em.remove(tr);
		}
	}
	
}
