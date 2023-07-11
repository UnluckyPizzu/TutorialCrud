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
	
	private EntityManager entityManager;
	
	
	@Autowired
	public TutorialRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

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
	
	

}
