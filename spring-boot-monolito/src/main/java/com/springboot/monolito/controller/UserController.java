package com.springboot.monolito.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.springboot.monolito.service.UserService;

@Controller
public class UserController {
	
	@Autowired
    private UserService userService;
	
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        return "login";
    }
    
    @RequestMapping("/logout")
    public String viewBye(Model model) {
        return "logout";
    }
    
	
	@RequestMapping("/err")
	public ModelAndView getError() {
		ModelAndView model = new ModelAndView();
		model.setViewName("error_login");
		return model;
	}
		
    @RequestMapping("/validator")
    public ModelAndView getValidator(@Valid HttpServletRequest req, HttpServletResponse res) {
    	ModelAndView model = new ModelAndView();
    	String userName =req.getParameter("username");
    	String password = req.getParameter("password");
    	if (userName.equals(userService.getByEmail(userName).getEmail()) 
    			&& password.equals(userService.getByEmail(userName).getPassword())) {
    		model.setViewName("redirect:/products");
    	}
    	else {
    		model.setViewName("error_login");
    	}
    	return model;
    }

}
