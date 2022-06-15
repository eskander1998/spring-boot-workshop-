package tn.esprit.spring.DAO;

import java.util.Date;
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
@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idUser")

	private Long idUser; 

	private String email;

	private String pwd;
	
	private String fName;

	private String IName;

	@Enumerated (EnumType.STRING)
	private Role role;
	
	
	@JsonIgnore
	  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
 // @JoinTable(name = "user_projects",  joinColumns = @JoinColumn(name = "user_id_user" , referencedColumnName = "idUser"),
   //       inverseJoinColumns = @JoinColumn(name = "id",  referencedColumnName = "id"))
	Set<Project> projects;
    
}
