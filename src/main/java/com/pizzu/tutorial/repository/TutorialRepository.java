package com.pizzu.tutorial.repository;

import java.util.List;

import com.pizzu.tutorial.model.Tutorial;

public interface TutorialRepository {
	List<Tutorial> getAllTutorial();
	Tutorial getTutorialById(long id);
	List<Tutorial> getAllPublishedTutorial();
	List<Tutorial> getTutorialByTitle(String name);
	Tutorial insertTutorial(Tutorial tutorial);
	Tutorial updateTutorial(Tutorial tutorial);
	int deleteById(long id);
	int deleteAllTutorial();
}
