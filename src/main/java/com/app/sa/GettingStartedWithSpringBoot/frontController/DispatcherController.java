/**
 * Understanding the importance of Dispatcher Controller/Servlet.
 */
package com.app.sa.GettingStartedWithSpringBoot.frontController;

/**
 * <p>
 * Spring MVC Request Flow<br/>
 * DispatcherServlet receives HTTP Request.<br/>
 * DispatcherServlet identifies the right Controller based
 * on the URL.<br/>
 * Controller executes Business Logic.<br/>
 * Controller returns a) Model b) View Name Back to
 * DispatcherServlet.<br/>
 * DispatcherServlet identifies the correct view
 * (ViewResolver).<br/>
 * DispatcherServlet makes the model available to view and
 * executes it.<br/>
 * DispatcherServlet returns HTTP Response Back.<br/>
 * </p>
 * 
 * @see Flow
 *      http://docs.spring.io/spring-framework/docs/2.0.8/reference/images/mvc.png
 * @author iHSPA
 */
public class DispatcherController {
	/*
	 * Power of Spring Boot Auto-Configuration facility
	 * which is not present in the Spring MVC. All the work
	 * that is contained and maintained by the
	 * DispatcherServlet is automatically handled by the
	 * Spring Boot Starter Web project configuration.
	 */
}
