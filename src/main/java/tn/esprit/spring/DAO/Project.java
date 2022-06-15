package tn.esprit.spring.DAO;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
public class Project {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")

	private Long id; 

	private String title;

	private String description;

    @ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<User> users;
	
	@JsonIgnore
	@OneToMany( cascade = CascadeType.PERSIST,fetch = FetchType.LAZY,mappedBy="project")
	private Set<Sprint> sprints;

	
	
	public Project() {
		super();
	}

	public Project(Long id, String title, String description, Set<User> users, Set<Sprint> sprints) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.users = users;
		this.sprints = sprints;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Sprint> getSprints() {
		return sprints;
	}

	public void setSprints(Set<Sprint> sprints) {
		this.sprints = sprints;
	} 
	 
	
}
