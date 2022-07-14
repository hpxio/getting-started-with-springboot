/**
 * Understanding Controller and its purpose. Demonstrate
 * what we can do with Controllers in Spring Boot applications.
 * 
 * @see Info https://www.baeldung.com/spring-controllers
 */
package com.app.hpx.gswspringboot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	/**
	 * Demonstrate simple Spring MVC Controller. In response
	 * to this controller invocation we'll send a <b>string message</b>
	 * and HTTP Response Status as {@code HTTP 202 ACCEPTED}.
	 * This behavior can be changed in {@code ResponseStatus}
	 * or removing it will return {@code HTTP 200 OK}.
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
	 * to find View <b>initApp/welcome</b> for ViewResolver.
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
	 * @see RequestParam https://www.baeldung.com/spring-request-param
	 * @see ModelViewMVVM https://www.baeldung.com/spring-mvc-model-model-map-model-view
	 */
	@PostMapping("/welcome_user")
	public String getWelcomeJspResponseWithUserInput(
			@RequestParam String userName, ModelMap modelMap) {
		/*
		 * NOTE: Here's an interesting
		 * scenario, in the above path mapping it is
		 * expecting to have a string type argument to be
		 * passed in request URL. But what if it is not
		 * passed? Simple the DispatcherServlet will assign
		 * NULL reference to the String initName and throw a
		 * 400 - Bad Request Error.
		 */

		/*
		 * Logging using following method id generally
		 * prohibited because it logs traces in the console,
		 * which is already flooded with Spring Bott's own
		 * logging. Hence it is advisable to implement log4j
		 * or use View Mapper to a error message and then
		 * use that in forms.
		 */

		/* System.out.println ( "Argument::InitName::" + userName ); */
		modelMap.put("userName", userName);
		return "/controller-demo/welcome";
	}

	/**
	 * Goal-3.A: Multi-valued Request URI
	 * 
	 * <pre/>
	 * Expected URL:
	 * http://localhost:8081/args/list?uname=%value1(String)%&uid=%value2(String)%&lnum=%value3(short)%
	 * 
	 * @param
	 * @return String, View name for the JSP page to return.
	 *         The Dispatcher Servlet finds the name of the
	 *         View and View Resolver tries map it to send
	 *         as response.
	 * @category View Resolver with Model Mapping
	 */
	@RequestMapping(path = "/app/list", method = RequestMethod.GET)
	public String getMultiArgsResponse(String uname,
			String uid, short lnum, ModelMap map) {

		map.put("id", uid.toUpperCase());
		map.put("name", uname.toUpperCase());
		map.put("lucky", lnum);

		return ("initApp/list");
	}

}
