package com.pizzu.tutorial.repository;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pizzu.tutorial.model.Platform;
import com.pizzu.tutorial.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pizzu.tutorial.model.Tutorial;
import com.pizzu.tutorial.model.TutorialSpecification;

@Repository
public class TutorialRepositoryImpl implements TutorialRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public List<Tutorial> getAllTutorial() {
		Query getQuery = entityManager.createQuery("from Tutorial");
		List<Tutorial> tutorials = getQuery.getResultList();
		
		return tutorials;
	}

	@Override
	public Tutorial getTutorialById(long id) {
		Tutorial tutorial = entityManager.find(Tutorial.class, id);
		
		return tutorial;
	}

	@Override
	public List<Tutorial> getAllPublishedTutorial() {
		Query getQuery = entityManager.createQuery("from Tutorial where published = true");
		List<Tutorial> tutorials = getQuery.getResultList();
		return tutorials;
	}

	@Override
	public List<Tutorial> getTutorialByTitle(String name) {
		Query getQuery = entityManager.createQuery("from Tutorial where title like ?0");
		getQuery.setParameter(0, "%" + name + "%");
		List<Tutorial> tutorials = getQuery.getResultList();
		
		return tutorials;
	}

	@Override
	public Tutorial insertTutorial(Tutorial tutorial) {
		entityManager.persist(tutorial); 
		return tutorial;
	}

	@Override
	public Tutorial updateTutorial(Tutorial tutorial) {
		return entityManager.merge(tutorial);
	}

	@Override
	public int deleteById(long id) {
		Query deleteQuery = entityManager.createQuery("delete from Tutorial where id = ?0");
		deleteQuery.setParameter(0, id);
		return deleteQuery.executeUpdate();
		
	}

	@Override
	public int deleteAllTutorial() {
		Query deleteQuery = entityManager.createQuery("delete from Tutorial");
		return deleteQuery.executeUpdate();
	}

	@Override
	public Tutorial insertSpecification(long id, TutorialSpecification specification) {
		Tutorial tutorial = entityManager.find(Tutorial.class, id);
		tutorial.setSpecification(specification);
		entityManager.merge(tutorial);
		return tutorial;
	}

	@Override
	public Tutorial insertAuthor(long id, Utente author) {
		Tutorial tutorial = entityManager.find(Tutorial.class, id);
		TutorialSpecification specification = tutorial.getSpecification();
		specification.setAuthor(author);

		entityManager.merge(tutorial);
		return tutorial;
	}

	@Override
	public Platform insertPlatform(long id, Platform platform) {
		Tutorial tutorial = entityManager.find(Tutorial.class,id);

		tutorial.getPlatforms().add(platform);

		entityManager.merge(tutorial);


		System.out.println(tutorial.toString() + tutorial.getPlatforms());
		return platform;
	}

	@Override
	public Platform insertPlatform(long id, long id_platform) {
		Tutorial tutorial = entityManager.find(Tutorial.class,id);
		Platform platform = entityManager.find(Platform.class,id_platform);

		tutorial.getPlatforms().add(platform);
		entityManager.merge(tutorial);


		System.out.println(platform.toString() + platform.getTutorials());
		return platform;
	}


}
