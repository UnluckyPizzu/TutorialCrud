package com.pizzu.tutorial.service;

import java.util.List;
import java.util.logging.LogManager;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzu.tutorial.model.Tutorial;
import com.pizzu.tutorial.model.TutorialSpecification;
import com.pizzu.tutorial.repository.*;

import net.bytebuddy.asm.Advice.This;


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
		return tutorialRepository.save(tutorial);
	}


	@Transactional
	@Override
	public Tutorial updateTutorial(Tutorial tutorial) {
		return tutorialRepository.updateTutorial(tutorial);
	}


	@Transactional
	@Override
	public int deleteTutorialById(long id) {
		return tutorialRepository.deleteById(id);
	}


	@Transactional
	@Override
	public int deleteAllTutorial() {
		return tutorialRepository.deleteAllTutorial();
	}


	@Transactional
	@Override
	public Tutorial insertSpecification(long id, TutorialSpecification specification) {
		
		return tutorialRepository.insertSpecification(id, specification);
	}
	
	

}
