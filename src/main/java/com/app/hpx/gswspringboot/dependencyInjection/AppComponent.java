/**
 * 
 */
package com.app.hpx.gswspringboot.dependencyInjection;

import org.springframework.stereotype.Component;

/**
 * @author COM
 */
@Component
public class AppComponent {

	/**
	 * @param strUname
	 * @param strUid
	 * @return
	 */
	public boolean validateInputs(String strUname,
			String strUid) {

		// Simple type of length validation on input //
		if (strUid.length() != 4
				&& strUname.length() != 5) {
			return false;
		}
		return true;
	}

}
