package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.DAO.Project;
import tn.esprit.spring.DAO.User;


public interface ProjectRepository  extends CrudRepository<Project, Long>{
   // @Query(value = "SELECT * FROM Project t1 INNER JOIN user_projects t2 ON t1.id = t2.projects_id WHERE t2.user_id_user = ?1 ")
   //List<Project> findAllByUserId(Long userId);
	
List<Project> findByUsers(User user);
}
