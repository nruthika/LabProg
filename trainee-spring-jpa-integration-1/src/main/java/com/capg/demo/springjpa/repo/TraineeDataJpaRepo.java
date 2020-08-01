package com.capg.demo.springjpa.repo;

import org.springframework.context.annotation.Bean;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.demo.springjpa.model.Trainee;

public interface TraineeDataJpaRepo extends JpaRepository<Trainee,Integer> {
	
public Trainee findBytraineeName(String traineeName);

}
