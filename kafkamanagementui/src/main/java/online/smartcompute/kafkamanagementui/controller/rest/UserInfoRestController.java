package online.smartcompute.kafkamanagementui.controller.rest;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import online.smartcompute.kafkamanagementui.model.User;

@RestController
@RequestMapping("/rest")
public class UserInfoRestController {
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public User currentUse(Authentication authentication) {
		User user = new User();
		user.setUserName(authentication.getName());
		return user;
	}
}
