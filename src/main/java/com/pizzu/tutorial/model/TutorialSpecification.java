package com.pizzu.tutorial.model;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tutorial_specification")
@Data
@NoArgsConstructor
public class TutorialSpecification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "author")
	private Utente author;
	
	@Column(nullable = false)
	private Integer views;
	
	@OneToOne(mappedBy = "specification" , cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Tutorial tutorial;
}
