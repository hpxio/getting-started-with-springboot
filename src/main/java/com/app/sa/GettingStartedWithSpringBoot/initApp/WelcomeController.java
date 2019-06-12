/**
 * Objectives
 * Goal-1: Return simple string to the web application on visiting the URL.
 * Return "Welcome User" when user redirects to http://localhost:8081/welcome
 * 
 * <pre/>
 * Goal-2: Return a JSP page in response to the GET request for a URL.
 * Return a JSP page saying "Welcome User!!" when URL requested. Create a
 * separate request mapping to a separate method.
 * 
 * <pre/>
 * Goal-3: Receive arguments in the request URL and return the values in the response.
 * Accept single value, multiple values in the request URI and map the view to display
 * sent values. Illustration of simple GET request/response mapping.
 */
package com.app.sa.GettingStartedWithSpringBoot.initApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author COM
 */
@Controller
public class WelcomeController {

	/**
	 * Goal-1: Return simple string to the web application
	 * on visiting the URL. Return "Welcome User" when user
	 * redirects to http://localhost:8081/welcome
	 * 
	 * @return String, The welcome message from the Web
	 *         Application
	 */
	@RequestMapping("/app/welcome/msg")
	@ResponseBody
	public String getWelcomeMessage() {
		return "Welcome to Getting Started Series on Spring Boot Application Development!!";
	}

	/**
	 * Goal-2: Return a JSP page in response to the GET
	 * request for a URL. Return a JSP page saying "Welcome
	 * User!!" when URL requested. Create a separate request
	 * mapping to a separate method.
	 * 
	 * @return String, View name for the JSP page to return.
	 *         The Dispatcher Servlet finds the name of the
	 *         View and View Resolver tries map it to send
	 *         as response.
	 * @category View Resolver
	 */
	@RequestMapping(path = "app/welcome", method = RequestMethod.GET)
	public String getWelcomeJSPResponse() {
		return "initApp/welcome";
	}

	/**
	 * Goal-3: Receive arguments in the request URL and
	 * return the values in the response. Accept single
	 * value, multiple values in the request URI and map the
	 * view to display sent values. Illustration of simple
	 * GET request/response mapping.
	 * 
	 * <pre/>
	 * Expected URL:
	 * http://localhost:8081/args/welcomejsp?initName=%value%
	 * 
	 * @param
	 * @return String, View name for the JSP page to return.
	 *         The Dispatcher Servlet finds the name of the
	 *         View and View Resolver tries map it to send
	 *         as response.
	 * @category View Resolver with Model Mapping
	 */
	@RequestMapping(path = "/app/args", method = RequestMethod.GET)
	public String getSingleArgResponse(
			@RequestParam String initName, ModelMap map) {

		/*
		 * FIXME: How to handle blank/null URL request where
		 * a arg is expected? Here's an interesting
		 * scenario, in the above path mapping it is
		 * expecting to have a string type argument to be
		 * passed in request URL. But what if it is not
		 * passed? Simple the DispatcherServlet will assign
		 * NULL reference to the String initName and throw a
		 * 400 - Bad Request Error.
		 */
		// Correction goes here //

		/*
		 * Logging using following method id generally
		 * prohibited because it logs traces in the console,
		 * which is already flooded with Spring Bott's own
		 * logging. Hence it is advisable to implement log4j
		 * or use View Mapper to a error message and then
		 * use that in forms. Example of view mapper present
		 * in com.app.sa.GettingStartedWithSpringBoot.
		 * dependencyInjection.Autowiring.
		 */

		// System.out.println ( "Argument::InitName::" +
		// initName );
		map.put("initName", initName.toUpperCase());
		return ("/initApp/welcome");
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
