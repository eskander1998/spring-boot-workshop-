package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.DAO.Project;

public interface IProjectService {

	public void addProject (Project project) ;
List<Project> allProjet();
public void assignProjectToUser(Long projectId, Long userId);

public List<Project> getProjectsByUser(Long userId);
}
