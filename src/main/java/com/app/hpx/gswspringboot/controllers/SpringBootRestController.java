package com.app.hpx.gswspringboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Understand RestController and its usage. Compare with traditional
 * Spring MVC Controller mentioned in previos class. Note that
 * RestController are built with RestAPI service in mind.
 * 
 * Spring 4.0 introduced the @RestController annotation in order to
 * simplify the creation of RESTful web services. It's a convenient
 * annotation that combines @Controller and @ResponseBody, which
 * eliminates the need to annotate every request handling method of
 * the controller class with the @ResponseBody annotation.
 */
@RestController
@RequestMapping("/app/v1/rest")
public class SpringBootRestController {

     /* Simple rest controller */
     @GetMapping("/welcome")
     public String getWelcomeStringResponse() {
          return "Welcome User";
     }

     /**                                                              
      * Let's see how to send data in URI in the RestAPI
      * endpoints.
      * 
      * PathVariable is used to retrieve values from URI.
      * Spring MVC allows you to use multiple PathVariable
      * annotations in the same method, provided, no more than
      * one argument has the same pattern. <b>@PathVariable</b>
      * can be optional. However, we should be careful when making
      * PathVariable optional, to avoid conflicts in paths.
      * 
      * @param user Name of the user to show on response
      * @return String, name of user received in request URI
      * 
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
}