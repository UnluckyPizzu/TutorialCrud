package com.pizzu.tutorial.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzu.tutorial.model.Tutorial;
import com.pizzu.tutorial.repository.*;

@Service
public class TutorialServiceImpl implements TutorialService {
	
	private TutorialJpaRepository tutorialRepository;
	

	@Autowired
	public TutorialServiceImpl(TutorialJpaRepository tutorialRepository) {
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



	@Override
	public List<Tutorial> findAllPublishedTutorial() {
		return tutorialRepository.findByPublishedIsTrue();
	}



	@Override
	public List<Tutorial> findTutorialByTitle(String name) {
		return tutorialRepository.findByTitleContainingIgnoreCase(name);
	}


	@Transactional
	@Override
	public Tutorial insertTutorial(Tutorial tutorial) {
		return tutorialRepository.insertTutorial(tutorial);
	}
	
	

}
