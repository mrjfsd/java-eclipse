package com.example.newlogin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
  @RequestMapping(value ="/login", method= RequestMethod.GET)
   public String loginpage() {
	  return "login";
  }

@RequestMapping(value = "/login", method= RequestMethod.POST)
 public String welcomepage(ModelMap model, @RequestParam String userid, @RequestParam String password ) {
	if(userid.equals("rayyan") && password.equals("root")) {
		model.put("userid", userid);
		return "welcome";
	}
	else if(userid.equals("kaleem") && password.equals("kal123")) {
		model.put("userid", userid);
		return "welcome";
	}
		
	model.put("errorMsg", "Please enter correct Details");
	return "login";
}

}