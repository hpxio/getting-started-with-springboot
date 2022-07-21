package com.app.hpx.gswspringboot.exception;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.hpx.gswspringboot.exception.ApplicationCommonErrorCodes;
import com.app.hpx.gswspringboot.exception.ExceptionUtil;
import com.app.hpx.gswspringboot.model.BookDetailsModel;
import com.app.hpx.gswspringboot.model.ErrorDetailsModel;
import com.app.hpx.gswspringboot.service.dependency_injection.DependencyClass;

public class DependencyClassAlternate {
	private static final Logger LOG = LoggerFactory.getLogger(DependencyClass.class);
	private final ErrorDetailsModel err = new ErrorDetailsModel();

	public void validate(BookDetailsModel bookDetails) {
		validateYearOfPublishing(bookDetails.getYearOfPublishing());
	}

	/**
	 * Validate Year of Publishing of a given Book.
	 *
	 * @param yearOfPublishing The year of publishing of Book
	 */
	private void validateYearOfPublishing(Integer yearOfPublishing) {
		LOG.info("Year of Publishing : {}", yearOfPublishing);
		if (yearOfPublishing < 1900 || yearOfPublishing > 2022) {
			throw ExceptionUtil.buildApplicationCommonExceptionFromErrorCode(
					ApplicationCommonErrorCodes.YEAR_OF_PUBLISHING);
		}
	}

	/**
	 * Validate author name (it cannot be blank)
	 *
	 * @param authorName Name of the author in the request
	 *
	 * @return boolean, true if name of author is in correct format
	 */
	private boolean validateBookAuthor(String authorName) {
		LOG.info("Author Name : {}", authorName);
		return Objects.nonNull(authorName) && authorName.length() >= 2;
	}

	/**
	 * Validate name of the book
	 *
	 * @param bookName Name of book in request
	 *
	 * @return boolean, true if name of book is in correct format
	 */
	private boolean validateBookName(String bookName) {
		LOG.info("Book Name : {}", bookName);
		return Objects.nonNull(bookName) && bookName.length() > 1;
	}
}
