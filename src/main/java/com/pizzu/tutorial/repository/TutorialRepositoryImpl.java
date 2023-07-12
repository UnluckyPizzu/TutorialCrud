package com.pizzu.tutorial.repository;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pizzu.tutorial.model.Tutorial;

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

	
	
}
