/**
 * 
 */
package com.app.sa.GettingStartedWithSpringBoot.dependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller is called as the "First Point of Contact" on
 * URL lookup. Controller may contain logics to validate
 * user inputs or even formatting logics to be executed
 * before sending back response to the client.<br/>
 * <div/> FIXME: What is difference b/w Service and
 * Component in Spring Boot? The validations logics can be
 * in separate class called as Component. To use those
 * services we need to instantiate service class first
 * before we can actually use that in our logics.<br/>
 * <br/>
 * <div/> This is where <b>Dependency Injection</b>,
 * Component, AutoWiring comes into picture.<br/>
 * 
 * <pre>
	 The job of @Controller is to create a Map of model
	 object and find a view but @RestController simply
	 return the object and object data is directly written
	 into HTTP response as JSON or XML.
	  
	 Read more:
	 https://javarevisited.blogspot.com/2017/08/difference
	 -between-restcontroller-and-controller-annotations-
	 spring-mvc-rest.html#ixzz5pIMpRwJS
 * </pre>
 * 
 * @author iHSPA
 */
@Controller
public class AppController {

	/**
	 * Difference B/w @Controller & @RestController
	 */

	// Dependency resolver using Auto-Wiring //
	@Autowired
	AppComponent insAppComponent;

	/**
	 * Expected URL: http://localhost:8081/app/validate
	 * 
	 * @return
	 */
	@RequestMapping(path = "/app/validate", method = RequestMethod.GET)
	public String getUserAndId() {
		return ("/dependencyInjection/get");
	}

	/**
	 * @param model
	 * @param txtUname
	 * @param txtUid
	 * @return
	 */
	@RequestMapping(path = "/app/validate", method = RequestMethod.POST)
	public String doValidateUserInput(ModelMap model,
			String txtUname, String txtUid) {
		// Call logic to first validate the request
		// arguments //
		boolean res = insAppComponent
				.validateInputs(txtUname, txtUid);

		// If the validation is successful then show OK
		// message else error message //
		if (res == true) {
			model.put("opMsg", "Input vlues are valid !!");
		} else {
			model.put("opMsg",
					"Input vlues are invalid !!");
		}
		return ("/dependencyInjection/validate");
	}
}
