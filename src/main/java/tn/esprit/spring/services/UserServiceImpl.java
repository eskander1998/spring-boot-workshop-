package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.User;
import tn.esprit.spring.repository.UserRepository;



@Service()
public class UserServiceImpl implements IUserService{

	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public User addUser(User user) {
		User us=userRepo.save(user);	
		return us;
	}

	@Override
	public List<User> retrieveAllUsers() {

		List<User> user =(List<User>) userRepo.findAll();
		
		return user;
	}
	
	
	

}
