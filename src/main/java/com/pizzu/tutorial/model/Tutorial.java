package com.pizzu.tutorial.model;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tutorial")
@Data
@NoArgsConstructor
public class Tutorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private Boolean published;

	/*
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tutorial_id")
	private TutorialSpecification specification;
	*/
}
