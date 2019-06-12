/**
 * 
 */
package com.app.sa.GettingStartedWithSpringBoot.userInteractions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * Objective: Understand mapping of different HTTP requests
 * and User Interactions<br/>
 * Goal-1:<br/>
 * Return simple Name/ID form on receiving GET request on
 * app/start.<br/>
 * <div/> Goal-2:<br/>
 * Return a simple Name/ID form on receiving GET request and
 * display the received parameter<br/>
 * from the request in the next page mapped at app/profile
 * page.<br/>
 * </p>
 * 
 * @author COM
 */
@Controller
public class PostMethod {

	/**
	 * Objective:<br/>
	 * Goal-1:<br/>
	 * Return simple Name/ID form on receiving GET request
	 * on app/start.<br/>
	 * 
	 * @return
	 */
	@RequestMapping(path = "/app/start", method = RequestMethod.GET)
	public String showStartPage() {
		return ("userInteractions/start");
	}

	/**
	 * Goal-2:<br/>
	 * Return a simple Name/ID form on receiving GET request
	 * and display the received parameter<br/>
	 * from the request in the next page mapped at
	 * app/profile page.<br/>
	 * </p>
	 * 
	 * @param model
	 * @param uname
	 * @param uid
	 * @return
	 */
	@RequestMapping(path = "/app/start", method = RequestMethod.POST)
	public String showProfilePage(ModelMap model,
			@RequestParam String uname,
			@RequestParam short uid) {
		model.put("uname", uname);
		model.put("uid", uid);
		return ("userInteractions/profile");
	}

}
