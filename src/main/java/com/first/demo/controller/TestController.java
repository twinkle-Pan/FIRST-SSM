package com.first.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

import com.first.demo.pojo.system.User;
import com.first.demo.service.UserService;

@Controller
public class TestController {
	@Autowired
	public UserService userService;
	
	 @RequestMapping(value="test",method=RequestMethod.GET)
    public ModelAndView index(Model model) throws Exception{
    	ModelAndView mv=new ModelAndView();
    	model.addAttribute("test", 123);
    	mv.setViewName("login");
		return mv;
    }
	 
	 
	@RequestMapping(value="loginForm",method=RequestMethod.POST)
	public ModelAndView login(User user) {
	ModelAndView mv=new ModelAndView();
		String judge=userService.findUser(user);
		/*String result=;*/
		mv.setViewName(judge.equals("success")?"index":"login");
		return mv;
	}
	 
}
