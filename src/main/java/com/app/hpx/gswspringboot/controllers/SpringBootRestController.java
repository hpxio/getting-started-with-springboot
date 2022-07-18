package com.app.hpx.gswspringboot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.hpx.gswspringboot.model.BookDetailsModel;

/**
 * Understand RestController and its usage. Compare with traditional
 * Spring MVC Controller mentioned in previous class. Note that
 * RestController are built with RestAPI service in mind.
 * <p>
 * Spring 4.0 introduced the @RestController annotation in order to
 * simplify the creation of RESTful web services. It's a convenient
 * annotation that combines @Controller and @ResponseBody, which
 * eliminates the need to annotate every request handling method of
 * the controller class with the @ResponseBody annotation.
 */
@RestController
@RequestMapping("/app/v1/rest")
public class SpringBootRestController {

	private static final Logger LOG = LoggerFactory.getLogger(SpringBootController.class);

	/*
	 * Simple rest controller. Notice that, to return
	 * simple String response we don't have to add
	 * ResponseBody annotation.
	 */
	@GetMapping("/welcome")
	public String getWelcomeStringResponse() {
		return "Welcome User";
	}

	/**
	 * Let's see how to send data in URI in the RestAPI
	 * endpoints.
	 * <p>
	 * PathVariable is used to retrieve values from URI.
	 * Spring MVC allows you to use multiple PathVariable
	 * annotations in the same method, provided, no more than
	 * one argument has the same pattern. <b>@PathVariable</b>
	 * can be optional. However, we should be careful when making
	 * PathVariable optional, to avoid conflicts in paths.
	 *
	 * @param user Name of the user to show on response
	 *
	 * @return String, name of user received in request URI
	 * @see https://www.baeldung.com/spring-pathvariable
	 */
	@GetMapping("/welcome/{user}")
	public String getWelcomeStringResponseFromPathVar(@PathVariable String user) {
		return user;
	}

	/**
	 * Multiple PathVariables example. Note that no parameters
	 * are optional in this. So missing any one of it will throw
	 * and error.
	 *
	 * @param userName Name of User (first path-var)
	 * @param title    Designation of User (second path-var)
	 *
	 * @return String Title & Designation phonebook style
	 */
	@GetMapping("/welcome_user/{userName}/{title}")
	public String getWelcomeStringResponseFromMultiplePathVar(
			@PathVariable String userName, @PathVariable String title) {
		return title + " " + userName;
	}

	/**
	 * Here's an example of optional PathVariable. Notice how
	 * the optional part of the URI is re-mapped in GetMapping.
	 * This is to avoid "404 NOT FOUND Error"
	 *
	 * @param id          ID of the User
	 * @param fullDetails Flag to send full-details or not
	 *
	 * @return String, if full-details requested build data accordingly
	 */
	@GetMapping({ "/user/{id}/{fullDetails}", "/user/{id}" })
	public String getWelcomeStringResponseFromOptionalPathVar(
			@PathVariable String id, @PathVariable(required = false) boolean fullDetails) {
		if (fullDetails) {
			return "F ull Details requested for : " + id;
		} else {
			return "Default details requested for : " + id;
		}
	}

	/**
	 * Let's understand the use of {@code @RequestParam} now. Spring uses
	 * {@code @RequestParam} to receive additional information for its processing.
	 * RequestParameters are also called as Query Parameters, and they can
	 * be optional or mandatory as per need. You can also assign default
	 * values for {@code @RequestParam}. The name of the {@code @RequestParam}
	 * can be different from the variable name in Spring.
	 * <p/>
	 * In the following example, image we want to store book details and for
	 * that we want to send following params from the Client. See how we
	 * can use {@code @RequestParam}
	 * <p/>
	 * NOTE: Make sure that the variable which is marked for "optional" is of
	 * type non-primitive (or should be object type), otherwise Spring might
	 * not be able to assign a default {@code null} and will throw
	 * 500 Internal Server Error.
	 *
	 * @param bookId           Unique Identifier for Book
	 * @param bookName         Name of the Book
	 * @param bookAuthor       Author of the Book
	 * @param yearOfPublishing Year of Publishing
	 *
	 * @return String, details of the book
	 * @see https://www.baeldung.com/spring-request-param
	 */
	@PostMapping("/book/create/option1")
	public String createBookDetails(
			@RequestParam int bookId,
			@RequestParam(defaultValue = "Book Name") String bookName, // default value if input absent //
			@RequestParam(required = false) Integer yearOfPublishing, // let's make this optional //
			@RequestParam(name = "author") String bookAuthor // different name from variable //
	) {

		StringBuilder sb = new StringBuilder();
		sb.append("bookId").append(" : ").append(bookId).append(" ");
		sb.append("bookName").append(" : ").append(bookName).append(" ");
		sb.append("bookAuthor").append(" : ").append(bookAuthor).append(" ");
		sb.append("yearOfPublishing").append(" : ").append(yearOfPublishing);

		LOG.info("Request data received : {}", sb);
		return sb.toString();
	}

	/**
	 * In the above example we have to create controller end-point with so many
	 * input parameters. Imagine if this list grows and we need to send more than
	 * 10 params. This is a code smell and is not a good practice. To avoid this
	 * Spring gives option to pass {@code @RequestParameters} as Object or as
	 * {@code @RequestBody}. Both have different purpose and usage.
	 * <p/>
	 * If you configure object (as mentioned in this example) then Spring will
	 * directly map values from Client request to underlying POJO for mathcing
	 * names. If the name of the fields do not match it will take them as null.
	 * To have control over defaults, naming convention and validation you need
	 * to use Jackson APIs, which is discussed in Validation classes.
	 * 
	 * @param bookData Details about the book
	 * @return BookData details received from the client
	 */
	@PostMapping("/book/create/option2")
	public BookDetailsModel createBookDetails(BookDetailsModel bookData) {
		LOG.info("Received request to create Book with : {}", bookData);
		return bookData;
	}

	/**
	 * In this example, we will create resource by taking inputs from
	 * HTTP Request Body. The name of the fields should match in the request.
	 * To have broader control like having default values, optional, etc.
	 * we can use Jackson APIs for mapping values. And we can also map some
	 * {@code @RequestParam} with {@code @RequestBody} in the same endpoint.
	 * 
	 * @param bookData Information about book to store
	 * @return Object, details of book stored
	 */
	@PostMapping("book/create/option3")
	public BookDetailsModel createBookDetailsFromRequestBody(@RequestBody BookDetailsModel bookData) {
		LOG.info("Received request to create Book with : {}", bookData);
		return bookData;
	}
}