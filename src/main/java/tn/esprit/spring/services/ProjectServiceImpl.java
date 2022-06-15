package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.Project;
import tn.esprit.spring.DAO.Sprint;
import tn.esprit.spring.DAO.User;
import tn.esprit.spring.repository.ProjectRepository;
import tn.esprit.spring.repository.UserRepository;

@Service()
public class ProjectServiceImpl  implements IProjectService{

	
	@Autowired
	ProjectRepository ProjectRepository;
	
	@Autowired
	UserRepository UserRepo;
	/*
	@Override
	public void addProject(Project project) { 

		Set<Sprint> sprints= new HashSet<>();

		Sprint s = new Sprint();
		s.setDescription("Sprint Mandat");
		s.setStartDate(new java.sql.Date(new java.util.Date().getTime()));
		s.setProject(project);
		sprints.add(s);
		project.setSprints(sprints);
		ProjectRepository.save(project);
	}*/
	
	
	public void addProject(Project project) {
		Set<Sprint> sprints= new HashSet<>();

		Sprint s = new Sprint();
		s.setDescription("Sprint Mandat");
		s.setStartDate(new java.sql.Date(new java.util.Date().getTime()));
		s.setProject(project);
		sprints.add(s);
		project.setSprints(sprints);
		ProjectRepository.save(project);
		
	}
	public List<Project> allProjet(){
		
		List <Project> proj = (List<Project>) ProjectRepository.findAll();
		return proj;
	}
	
	@Override
	public void assignProjectToUser(Long projectId, Long userId){
		User user = UserRepo.findById(userId).get();
		Project proj = ProjectRepository.findById(projectId).get();
		
		Set<Project> Projects= new HashSet<>();
		Projects.add(proj);
		user.setProjects(Projects);
		UserRepo.save(user);
		
		/*
		 * 	User user = UserRepo.findById(userId).get();
		Project proj = ProjectRepository.findById(projectId).get();
		
		Set<User> Users= new HashSet<>();
		Users.add(user);
		
		proj.setUsers(Users);
		ProjectRepository.save(proj);*/
		 
	}
	
	@Override
	public List<Project> getProjectsByUser(Long userId) {
	//User user= UserRepo.findById(userId).get();
		//List<Project> projects= ProjectRepository.findByUsers(user);
		
		
		// TODO Auto-generated method stub
//		Set<Project> Projects=  (HashSet<Project>) pr.findAll();
		
		  List<Project> Projects = (List<Project>) ProjectRepository.findAll();
		  List<Project> Projects2 = new ArrayList<>();

//		Set<Project> Projects2= new HashSet<>();

		for (Project Project:Projects )
		{
			for (User users:Project.getUsers())
			{
				if (users.getIdUser()==userId)
					{Projects2.add(Project);}
							
					}
			
		}
		
		return Projects2;
		
		
	}
	
	


}
