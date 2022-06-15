package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.DAO.Project;
import tn.esprit.spring.DAO.User;
import tn.esprit.spring.services.ProjectServiceImpl;
import tn.esprit.spring.services.UserServiceImpl;



@RestController
public class mainRestController {

	
	  @Autowired
	    UserServiceImpl UserServiceImpl;
	  @Autowired
	    ProjectServiceImpl ProjectServiceImpl;
	  
	  @PostMapping("/add-user")
		@ResponseBody
		public User addClient(@RequestBody User user)
		{
		  User user1 = UserServiceImpl.addUser(user);
		return user1; 
		}

	    	@GetMapping("/listeusers")
	    	@ResponseBody
	    	public List<User> retrieveAllUsers(){
	    		
	    		return UserServiceImpl.retrieveAllUsers();
	    	}  
	    	
	    	@PostMapping("/add-project")
	  		@ResponseBody
	  		public void addprojet(@RequestBody Project Project)
	  		{
	    		 ProjectServiceImpl.addProject(Project);
	    		  
	  		}
	    	
	    	@GetMapping("/listprojet")
	    	@ResponseBody
	    	public List<Project> allProjet(){
	    		
	    		return ProjectServiceImpl.allProjet();
	    	} 
	    	
	    	
	    	 @PutMapping("/affecter/{projet}/{user}")
		 	    @ResponseBody
		 		public void assignProjectToUser(@PathVariable("projet")  Long idParcAuto, @PathVariable("user")  Long idVoiture){
		 	    	
	    		 ProjectServiceImpl.assignProjectToUser(idParcAuto, idVoiture);
		 	    }
	    	 
	    	 
	    	 
	    		@GetMapping("/projetbyiduser/{iduser}")
		    	@ResponseBody
		    	public List<Project> projetbyiduser(@PathVariable("iduser")  Long iduser){
		    		
		    		return ProjectServiceImpl.getProjectsByUser(iduser);
		    	} 
}
