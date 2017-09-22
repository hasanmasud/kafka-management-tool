package online.smartcompute.kafkamanagementui.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 
 * @author masud
 *
 */
@Controller
public class HomePageController {

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
    public String performGet() {
		return "homepage";
    }
	
}
