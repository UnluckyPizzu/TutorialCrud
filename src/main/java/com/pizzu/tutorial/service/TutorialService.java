package com.pizzu.tutorial.service;

import java.util.List;

import com.pizzu.tutorial.model.Tutorial;

public interface TutorialService {
	public List<Tutorial> findAll();
	public Tutorial findTutorialById(long id);
	public List<Tutorial> findAllPublishedTutorial();
	public List<Tutorial> findTutorialByTitle(String name);
	public Tutorial insertTutorial(Tutorial tutorial);
}
