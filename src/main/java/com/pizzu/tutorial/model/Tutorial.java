package com.pizzu.tutorial.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

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


	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinColumn(name = "specification")
	private TutorialSpecification specification;


	@Override
	public String toString() {
		return "Tutorial{" +
				"id=" + id +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", published=" + published +
				'}';
	}

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "tutorial_platform",
			joinColumns = @JoinColumn(name = "id_tutorial"),
			inverseJoinColumns = @JoinColumn(name = "id_platform")
	)
	Set<Platform> platforms;
}
