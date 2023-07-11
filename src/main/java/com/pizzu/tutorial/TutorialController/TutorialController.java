package com.pizzu.tutorial.TutorialController;

import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.hibernate.engine.query.spi.sql.NativeSQLQueryCollectionReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pizzu.tutorial.model.Tutorial;
import com.pizzu.tutorial.service.TutorialService;

@RestController
@RequestMapping("/tutorials")
public class TutorialController {

	private TutorialService tutorialService;

	@Autowired
	public TutorialController(TutorialService tutorialService) {
		this.tutorialService = tutorialService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<Tutorial>> findAll(@RequestParam(required = false, name = "title") String name) {
		if(name == null)
			return new ResponseEntity<List<Tutorial>>(tutorialService.findAll(), HttpStatus.OK);
		else {
			return new ResponseEntity<List<Tutorial>>(tutorialService.findTutorialByTitle(name), HttpStatus.OK);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tutorial> findTutorialById(@PathVariable long id) {
		Optional<Tutorial> tutorial = Optional.ofNullable(tutorialService.findTutorialById(id));
		if(tutorial.isPresent()) {
			return new ResponseEntity<Tutorial>(tutorial.get(),HttpStatus.OK);
		} else {
			return new ResponseEntity<Tutorial>(new Tutorial(),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/published")
	public ResponseEntity<List<Tutorial>> findAllPublishedTutorial() {
		return new ResponseEntity<List<Tutorial>>(tutorialService.findAllPublishedTutorial(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Tutorial> postTutorial(@RequestBody Tutorial tutorial) {
		return new ResponseEntity<Tutorial>(tutorialService.insertTutorial(tutorial), HttpStatus.CREATED);
	}
	
	
}
