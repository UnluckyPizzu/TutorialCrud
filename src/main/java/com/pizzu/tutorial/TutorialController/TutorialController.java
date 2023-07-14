package com.pizzu.tutorial.TutorialController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;
import javax.xml.crypto.Data;

import com.pizzu.tutorial.model.Platform;
import com.pizzu.tutorial.model.Utente;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.hibernate.engine.query.spi.sql.NativeSQLQueryCollectionReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.RequestScope;

import com.pizzu.tutorial.model.Tutorial;
import com.pizzu.tutorial.model.TutorialSpecification;
import com.pizzu.tutorial.service.TutorialService;

@RestController
@RequestMapping("/tutorials")
public class TutorialController {
	
	private final Date date = new Date();

	private TutorialService tutorialService;

	@Autowired
	public TutorialController(TutorialService tutorialService) {
		this.tutorialService = tutorialService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<Tutorial>> findAll(@RequestParam(required = false, name = "title") String name) {
		System.out.println(date.toString());
		
		
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
	
	@PutMapping("/{id}")
	public ResponseEntity<Tutorial> putSpecificationTutorial(@PathVariable long id, @RequestBody TutorialSpecification specification) {
		return new ResponseEntity<Tutorial>(tutorialService.insertSpecification(id, specification), HttpStatus.CREATED);
	}

	@PutMapping("/author/{id}")
	public ResponseEntity<Tutorial> putAuthorTutorial(@PathVariable long id, @RequestBody Utente author) {
		return new ResponseEntity<Tutorial>(tutorialService.insertAuthor(id, author), HttpStatus.CREATED);
	}

	@PutMapping("/platform/{id}")
	public ResponseEntity<Platform> putPlatformTutorial(@PathVariable long id, @RequestBody Platform platform) {
		return new ResponseEntity<Platform>(tutorialService.insertPlatform(id, platform), HttpStatus.CREATED);
	}

	@PutMapping("/platform")
	public ResponseEntity<Platform> putPlatformTutorial(@RequestParam(name = "id") long id, @RequestParam(name = "id_platform")  long id_platform) {
		System.out.println("prova");
		return new ResponseEntity<Platform>(tutorialService.insertPlatform(id, id_platform), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Tutorial> putTutorial(@RequestBody Tutorial tutorial) {
		return new ResponseEntity<Tutorial>(tutorialService.updateTutorial(tutorial), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deleteTutorialById(@PathVariable long id) throws Exception {
		return new ResponseEntity<Integer>(tutorialService.deleteTutorialById(id), HttpStatus.OK);
	}
	
	@DeleteMapping()
	public ResponseEntity<Integer> deleteAllTutorial() {
		return new ResponseEntity<Integer>(tutorialService.deleteAllTutorial(), HttpStatus.OK);
	}
	
}
