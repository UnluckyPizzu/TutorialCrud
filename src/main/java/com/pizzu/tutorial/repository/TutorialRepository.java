package com.pizzu.tutorial.repository;

import java.util.List;

import com.pizzu.tutorial.model.Tutorial;

public interface TutorialRepository {
	List<Tutorial> getAllTutorial();
	Tutorial getTutorialById(long id);
}
