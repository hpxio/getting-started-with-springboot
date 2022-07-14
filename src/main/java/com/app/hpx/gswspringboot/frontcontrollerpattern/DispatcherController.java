/**
 * Understanding the importance of Dispatcher Controller/Servlet.
 * Front Controller is defined as “a controller that handles all
 * requests for a Web site”.
 * 
 * @see info Front Contrller Pattern
 * 		https://www.baeldung.com/java-front-controller-pattern
 */
package com.app.hpx.gswspringboot.frontcontrollerpattern;

/**
 * <p>
 * Spring MVC Request Flow
 * DispatcherServlet receives HTTP Request.
 * It identifies the right Controller based
 * on the URL. Controller executes Business Logic.
 * Controller returns a) Model b) View Name Back to
 * DispatcherServlet. DispatcherServlet identifies
 * the correct view (ViewResolver). DispatcherServlet
 * makes the model available to view andexecutes it.
 * DispatcherServlet returns HTTP Response Back.
 * </p>
 * 
 * @see info Flow
 *      http://docs.spring.io/spring-framework/docs/2.0.8/reference/images/mvc.png
 * 
 * @see info Dispatcher Servlet Working
 *      https://www.baeldung.com/spring-dispatcherservlet
 */
public interface DispatcherController {
	/*
	 * do-nothing - interface to expplain some definitions
	 * Power of Spring Boot Auto-Configuration facility
	 * which is not present in the Spring MVC. All the work
	 * that is contained and maintained by the
	 * DispatcherServlet is automatically handled by the
	 * Spring Boot Starter Web project configuration.
	 */
}
