package com.app.hpx.gswspringboot.service.dependency_injection;

import java.util.Objects;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.app.hpx.gswspringboot.model.BookDetailsModel;

/**
 * To understand DependencyInjection let's take example of Validation
 * of request data before passing/processing it to Service business
 * logics. In this class, we will take request object and try to verify
 * that data is according to certain expectations and if not then ask
 * Service layer to stop further processing.
 * <p>
 * By convention, Spring enforces "Separation of Concerns" design. The
 * validation of request is one of the concern in the entire request -
 * response flow. Hence we are creating different class which will be
 * "injected" in the Service layer.
 */
@Component
public class DependencyClass { // Validation-class

	private static final Logger LOG = org.slf4j.LoggerFactory
			.getLogger(DependencyClass.class);

	/**
	 * Validate Book Details. If there are null values or invalid
	 * range, etc. then validation fails.
	 *
	 * @param bookData Details of Book from request
	 *
	 * @return booleam, true if validation is successful
	 */
	public boolean validateRequest(BookDetailsModel bookData) {
		return validateYearOfPublishing(bookData.getYearOfPublishing()) &&
				validateBookAuthor(bookData.getBookAuthor()) &&
				validateBookName(bookData.getBookAuthor());
	}

	/**
	 * Validate Year of Publishing of a given Book.
	 *
	 * @param yearOfPublishing The year of publishing of Book
	 *
	 * @return boolean, True if range is correct
	 */
	private boolean validateYearOfPublishing(Integer yearOfPublishing) {
		LOG.info("Year of Publishing : {}", yearOfPublishing);
		return 1900 > yearOfPublishing && 2022 < yearOfPublishing;
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