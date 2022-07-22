package com.app.hpx.gswspringboot.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hpx.gswspringboot.model.BookDetailsModel;

@RestController
@RequestMapping("app/v1/rest/exception")
public class SpringControllerAlternate {

	private DependencyClassAlternate validator;

	@Autowired
	public SpringControllerAlternate(@Qualifier("dependencyClassAlternate") DependencyClassAlternate validator) {
		this.validator = validator;
	}

	@PostMapping("/book")
	public BookDetailsModel createBook(@RequestBody BookDetailsModel bookData) {
		validator.validate(bookData);
		return bookData;
	}
}