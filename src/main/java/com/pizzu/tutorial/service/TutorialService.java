package com.pizzu.tutorial.service;

import java.util.List;

import com.pizzu.tutorial.model.Platform;
import com.pizzu.tutorial.model.Tutorial;
import com.pizzu.tutorial.model.TutorialSpecification;
import com.pizzu.tutorial.model.Utente;

public interface TutorialService {
	public List<Tutorial> findAll();
	public Tutorial findTutorialById(long id);
	public List<Tutorial> findAllPublishedTutorial();
	public List<Tutorial> findTutorialByTitle(String name);
	public Tutorial insertTutorial(Tutorial tutorial);
	public Tutorial insertSpecification(long id, TutorialSpecification specification);
	public Platform insertPlatform(long id, Platform platform);
	public Platform insertPlatform(long id, long id_platfomr);
	public Tutorial insertAuthor(long id, Utente author);
	public Tutorial updateTutorial(Tutorial tutorial);
	public int deleteTutorialById(long id) throws Exception;
	public int deleteAllTutorial();
}
