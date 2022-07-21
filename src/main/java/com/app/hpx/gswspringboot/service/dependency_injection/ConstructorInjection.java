package com.app.hpx.gswspringboot.service.dependency_injection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hpx.gswspringboot.model.BookDetailsModel;
import com.app.hpx.gswspringboot.model.ErrorDetailsModel;
import com.app.hpx.gswspringboot.model.response.CreateBookDetailsResponse;

/**
 * Dependency Injection using same example as class FieldInjection but
 * using Spring Constructor Injection.
 *
 * @see <a href="https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring">Dependency Injection</a>
 */
@RestController
@RequestMapping("/app/v1/rest")
public class ConstructorInjection { // The Controller

	private static final Logger LOG = LoggerFactory.getLogger(ConstructorInjection.class);

	private final DependencyClass validator;

	/*
	 * This is Constructor Injection using Autowiring.
	 * Although, @Autowired is not required when using Constructor
	 * Injection.
	 */
	@Autowired
	public ConstructorInjection(@Qualifier("dependencyClass") DependencyClass validator) {
		this.validator = validator;
	}

	/**
	 * Demonstrate constructor injection in use.
	 *
	 * @param bookData Information about book to store
	 *
	 * @return Object, details of book stored
	 */
	@PutMapping("/book")
	public ResponseEntity<CreateBookDetailsResponse> createBookDetailsFromRequestBody(
			@RequestBody BookDetailsModel bookData) {

		CreateBookDetailsResponse cr = new CreateBookDetailsResponse();
		cr.setBookDetailsModel(bookData);

		if (!validator.validateRequest(bookData)) {
			LOG.error("Input invalid : {}", bookData);
			cr.setErrorDetailsModel(generateErrorDetails(
					HttpStatus.BAD_REQUEST.value(), "Input invalid", "Request Data"));

			return new ResponseEntity<>(cr, HttpStatus.BAD_REQUEST);
		}

		/* call service logic here */
		return new ResponseEntity<>(cr, HttpStatus.OK);
	}

	private ErrorDetailsModel generateErrorDetails(int code, String message, String type) {
		return new ErrorDetailsModel(code, message, type);
	}
}