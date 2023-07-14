package com.pizzu.tutorial.repository;

import java.util.List;

import com.pizzu.tutorial.model.Platform;
import com.pizzu.tutorial.model.Tutorial;
import com.pizzu.tutorial.model.TutorialSpecification;
import com.pizzu.tutorial.model.Utente;

public interface TutorialRepository {
	List<Tutorial> getAllTutorial();
	Tutorial getTutorialById(long id);
	List<Tutorial> getAllPublishedTutorial();
	List<Tutorial> getTutorialByTitle(String name);
	Tutorial insertTutorial(Tutorial tutorial);
	Tutorial insertSpecification(long id, TutorialSpecification specification);
	Tutorial insertAuthor(long id, Utente author);

	Platform insertPlatform(long id,Platform platform);
	Platform insertPlatform(long id,long id_platform);
	Tutorial updateTutorial(Tutorial tutorial);
	int deleteById(long id);
	int deleteAllTutorial();
}
