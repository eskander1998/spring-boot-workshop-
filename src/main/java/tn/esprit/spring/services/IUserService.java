package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.DAO.User;


public interface IUserService {
	
		User addUser (User user);
		
		List<User> retrieveAllUsers();
}
