package com.pizzu.tutorial.service;

import java.util.List;
import java.util.logging.LogManager;

import javax.transaction.Transactional;

import com.pizzu.tutorial.model.Utente;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import com.pizzu.tutorial.model.Tutorial;
import com.pizzu.tutorial.model.TutorialSpecification;
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
	public synchronized Tutorial findTutorialById(long id) {
		
		if(id == 7) {
			try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
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


	@Transactional(rollbackOn = Exception.class)
	@Override
	public int deleteTutorialById(long id) throws Exception {
		int del = tutorialRepository.deleteById(id);
		/*
		if(del == 1)
			throw new Exception("Exception message");
		 */
		return del;
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

	@Transactional
	@Override
	public Tutorial insertAuthor(long id, Utente author) {
		return tutorialRepository.insertAuthor(id,author);
	}


}
