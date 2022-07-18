/**
 * Understanding Controller and its purpose. Demonstrate
 * what we can do with Controllers in Spring Boot applications.
 * 
 * @see Info https://www.baeldung.com/spring-controllers
 */
package com.app.hpx.gswspringboot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controllers provide access to the application behavior
 * that you typically define through a service interface.
 * Controllers interpret user input and transform it into
 * a model that is represented to the user by the view.
 * 
 * In the traditional approach, MVC applications are not
 * service-oriented hence there is a View Resolver that
 * renders final views based on data received from a
 * Controller.
 */
@Controller
@RequestMapping("/app/v1/")
public class SpringBootController {

	private static final Logger LOG = LoggerFactory.getLogger(SpringBootController.class);

	/**
	 * Demonstrate simple Spring MVC Controller. In response
	 * to this controller invocation we'll send a <b>string message</b>
	 * and HTTP Response Status as {@code HTTP 202 ACCEPTED}.
	 * This behavior can be changed in {@code ResponseStatus}
	 * or removing it will return {@code HTTP 200 OK} by default.
	 * 
	 * <p/>
	 * 
	 * {@link ResponseBody} ensures that ViewResolver forms a
	 * "string/json or configured MediaType.VALUE" response object.
	 * If {@code ResponseBody} is removed Spring will try to find
	 * a matching View of type "/welcome.jsp".
	 * 
	 * @return String The welcome message
	 */
	@ResponseBody
	@GetMapping(value = "/welcome", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String getWelcomeStringResponse() {
		return "Welcome Spring Boot Application Development!!";
	}

	/**
	 * As compared to above controller endpoint, in this
	 * we return a JSP page instead of a String. Notice that
	 * {@link ResponseBody} is not used since we want Spring
	 * to find apt View <b>initApp/welcome</b> for ViewResolver.
	 * 
	 * @return String, View name for the JSP page to return.
	 *         The Dispatcher Servlet finds the name of the View and
	 *         View Resolver tries map it to send as response.
	 */
	@GetMapping("/welcome_user")
	@ResponseStatus(HttpStatus.CREATED)
	public String getWelcomeJspResponse() {
		/*
		 * NOTE: to correctly identify path where ViewResolver can
		 * find apt Views we configured properties :
		 * spring.mvc.view.prefix & spring.mvc.view.suffix
		 */
		return "controller-demo/welcome";
	}

	/**
	 * In the above two examples we are returning a static response.
	 * What if we want to respond with a dynamic data? Let's say,
	 * instead of saying "Welcome User" we want to say "Welcome %name%"
	 * where %name% will be given by user during controller invocation.
	 * Notice that since we are creating a resource (user name here)
	 * it is good to use <b>HTTP POST</b> method.
	 * <p/>
	 * For this we will use Model part of Spring MVC and {@code ModelMap}
	 * object to share data between business logic and view layers.
	 * <p/>
	 * {@link RequestParam} allows clients to send data as input to the
	 * API.
	 * 
	 * @param userName Name of user to show on View
	 * @param modelMap Model object to share data to View
	 * @return String, View name for the JSP page to return.
	 * 
	 * @see RequestParam https://www.baeldung.com/spring-request-param
	 * @see ModelViewMVVM
	 *      https://www.baeldung.com/spring-mvc-model-model-map-model-view
	 */
	@PostMapping("/welcome_user")
	public String getWelcomeJspResponseWithUserInput(
			@RequestParam String userName, ModelMap modelMap) {
		/*
		 * NOTE: Here's an interesting
		 * scenario, in the above path mapping it is
		 * expecting a string type argument in request
		 * URL. But what if it is not passed? Simple the
		 * DispatcherServlet will assign NULL reference to
		 * the String initName.
		 */

		/*
		 * Logging using System.out.println() is generally
		 * prohibited because it logs traces in the console,
		 * which is already flooded with Spring Boot's own
		 * logging. Hence it is advisable to implement log4j
		 * or use View Mapper to a error message and then
		 * use that in forms. More details in Spring Logging
		 * demo class.
		 */

		/* bad ->> System.out.println ( "Argument::InitName::" + userName ); */
		/* good ->> */ LOG.info("Dynamic Response Controller with input : {}", userName);

		modelMap.put("userName", userName);
		return "/controller-demo/welcome";
	}

	/**
	 * Now we know how to respond with a simple String as well as
	 * with JSP page (the View). We also saw example how to send
	 * data from controller to View (dynamic pages). Let's try to
	 * send multiple data to View.
	 * <p/>
	 *
	 * @param
	 * @return String, View Name
	 * @category String, View name for the JSP page to return.
	 */
	@PostMapping("/info/list")
	public String getMultiArgsResponse(String userName, String userId, short seqNum, ModelMap map) {
		
		/* do some processing with input and return. Notice 
		 * that input parameters are not marked with @RequestParam
		 * but still this will work until client sends input for
		 * all the given params. If any param is missing then Spring
		 * will throw 500 Internal Server error. This is because
		 * all params are default treated as "non-optional".
		 */

		map.put("id", userId);
		map.put("name", userName);
		map.put("seq", seqNum);

		/* If client tries to send same parameter multiple times,
		 * Spring does not throw any error unless you implement a
		 * validation layer. For example, if client sends 'userName'
		 * as 'Jack' and then again sends 'userName' as 'Harry' in the 
		 * same request, Spring will concatenate the inputs as 
		 * 'userName':'Jack, Harry'.
		 */

		return "controller-demo/list";
	}

}
