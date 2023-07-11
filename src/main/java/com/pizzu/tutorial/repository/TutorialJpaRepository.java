package com.pizzu.tutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzu.tutorial.model.Tutorial;

public interface TutorialJpaRepository extends JpaRepository<Tutorial, Long>, TutorialRepository {
	List<Tutorial> findByTitleContainingIgnoreCase(String name);
	
	List<Tutorial> findByPublishedIsTrue();
}
