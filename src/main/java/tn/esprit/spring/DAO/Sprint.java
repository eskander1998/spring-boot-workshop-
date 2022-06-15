package tn.esprit.spring.DAO;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
public class Sprint {
	
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name="id")

private Long id; 

private String description;

@Temporal(TemporalType.DATE)
private Date startDate;

@ManyToOne( cascade = CascadeType.ALL)
private Project project;

public Sprint(Long id, String description, Date startDate, Project project) {
	super();
	this.id = id;
	this.description = description;
	this.startDate = startDate;
	this.project = project;
}


public Sprint() {
	super();
}


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Date getStartDate() {
	return startDate;
}

public void setStartDate(Date startDate) {
	this.startDate = startDate;
}

public Project getProject() {
	return project;
}

public void setProject(Project project) {
	this.project = project;
}



}
