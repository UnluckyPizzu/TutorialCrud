package com.pizzu.tutorial.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.engine.query.spi.sql.NativeSQLQueryCollectionReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzu.tutorial.model.Tutorial;
import com.pizzu.tutorial.repository.*;

@Service
public class TutorialServiceImpl implements TutorialService {
	
	private TutorialRepository tutorialRepository;
	

	@Autowired
	public TutorialServiceImpl(TutorialRepository tutorialRepository) {
		this.tutorialRepository = tutorialRepository;
	}



	@Override
	public List<Tutorial> findAll() {
		return tutorialRepository.getAllTutorial();
	}



	@Override
	public Tutorial findTutorialById(long id) {
		return tutorialRepository.getTutorialById(id);
	}
	
	

}
