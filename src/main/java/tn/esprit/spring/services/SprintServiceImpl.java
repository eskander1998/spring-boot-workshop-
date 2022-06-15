package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.DAO.Project;
import tn.esprit.spring.DAO.Sprint;
import tn.esprit.spring.repository.SprintRepository;

public class SprintServiceImpl implements ISprintService{

	
	@Autowired
	SprintRepository sprintRepo;
	

}
