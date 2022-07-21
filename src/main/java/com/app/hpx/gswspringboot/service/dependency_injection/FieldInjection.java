package com.app.hpx.gswspringboot.service.dependency_injection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hpx.gswspringboot.model.BookDetailsModel;

/**
 * Dependency Injection is a fundamental aspect of the Spring
 * framework, through which the Spring container “injects”
 * objects into other objects or “dependencies”. Simply put,
 * this allows for loose coupling of components and moves the
 * responsibility of managing components onto the container.
 *
 * @see <a href="https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring">Dependency Injection</a>
 */
@RestController
@RequestMapping("/app/v1/rest")
public class FieldInjection { // The Controller

	private static final Logger LOG = LoggerFactory.getLogger(FieldInjection.class);

	/* This is Field Dependency Injection using Autowiring. */
	@Autowired
	@Qualifier("dependencyClass")
	private DependencyClass validation;

	/**
	 * Let's take example from our RestController class of creating a
	 * new resource called BookDetails. But before we can store the data
	 * we should validate that data is in correct format/value. For this
	 * we will make a call to "validate" the details and if everything is
	 * correct then we'll proceed with underlying service logic.
	 * 
	 * @param bookData Information about book to store
	 * @return Object, details of book stored
	 */
	@PostMapping("/book")
	public ResponseEntity<String> createBookDetailsFromRequestBody(@RequestBody BookDetailsModel bookData) {
		ResponseEntity<String> re = new ResponseEntity<>(HttpStatus.OK);
		if (!validation.validateRequest(bookData)) {
			LOG.error("Input invalid : {}", bookData);
			re = new ResponseEntity<>("Bad input!", HttpStatus.BAD_REQUEST);
			return re;
		}

		/* call service logic here */
		return re;
	}
}