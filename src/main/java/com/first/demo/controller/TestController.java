package com.first.demo.controller;



import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
	private UserService userService;
	
	 @RequestMapping(value="/test",method=RequestMethod.GET)
    public String mv(User user,String permission) throws Exception{
			Subject subject = SecurityUtils.getSubject();
			//return subject != null && subject.isPermitted(permission);
			
				return "login";
			
	/*		ModelAndView mv=new ModelAndView();
			UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),
					user.getPassword());

			Subject currentUser = SecurityUtils.getSubject();
			try {
				System.out.println("----------------------------");
				if (!currentUser.isAuthenticated()) {
					// token.setRememberMe(true);
					currentUser.login(token);
				}
				result = "{'result':true}";
				System.out.println("result: " + result);
			} catch (Exception e) {
				//logger.error(e.getMessage());
				result = "{'result':false,'msg':'用户名或密码错误！'}";
			}*/

			
		/* ModelAndView mv=new ModelAndView();
    	model.addAttribute("test", 123);
    	mv.setViewName("login");
		return mv;*/
	 
	 }
	@RequestMapping(value="/loginForm",method=RequestMethod.POST)
	@ResponseBody
	public String login(HttpServletRequest request,User user) {
		String name=request.getParameter("username");
		String psString=request.getParameter("password");
		String result="";
		ModelAndView mv=new ModelAndView();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),
				user.getPassword());

		Subject currentUser = SecurityUtils.getSubject();
		try {
			System.out.println("----------------------------");
			if (!currentUser.isAuthenticated()) {
				// token.setRememberMe(true);
				currentUser.login(token);
			}
			result = "{'result':true}";
			System.out.println("result: " + result);
			//mv.setViewName("index");
		} catch (Exception e) {
			//logger.error(e.getMessage());
			result = "{'result':false,'msg':'用户名或密码错误！'}";
			//mv.setViewName("login");
		}
		
		return result;
		
	
		//String judge=userService.findUser(user);
		/*String result=;*/
		/*mv.setViewName(judge.equals("success")?"index":"login");
		return mv;*/
	}
	
	@RequestMapping(value="/main")
	public ModelAndView mv()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		return mv;
		
	}
	
	 
}
