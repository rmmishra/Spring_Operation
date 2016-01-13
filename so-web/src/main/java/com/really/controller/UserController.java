package com.really.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.really.model.UserData;
import com.really.service.UserServices;
import com.really.validator.UserValidater;

@Controller
public class UserController 
{

	@Autowired
	private UserServices userServices;
	
	@Autowired
	private UserValidater userValidater;

	@RequestMapping("viewuser")
	public ModelAndView viewUserInfo()
	{
		List<UserData> list=userServices.viewUserInfo();
		return new ModelAndView("viewuser","userList",list);
	}
	
	@RequestMapping("registeruser")
	public ModelAndView registerUser(Model model)
	{
		model.addAttribute("UserData", new UserData());
		return new ModelAndView("registernewuser");
	}
	
	@RequestMapping(value="/registeruserinfo",method=RequestMethod.POST)
	public ModelAndView registeruserinfo(@ModelAttribute("UserData") UserData userData, BindingResult result)
	{
		userValidater.validate(userData, result);
		if(result.hasErrors())
		{
			return new ModelAndView("registernewuser");
		}
		
		int n=userServices.registerUser(userData);
		String msg="Your Registration is fail ! ";
		if(n>0)
		{
			msg="Your Registration is success ! ";
		}
		return new ModelAndView("registernewuser","msg",msg);
	}
	
	@RequestMapping("updateuser")
	public ModelAndView updateUser(Model model)
	{
		model.addAttribute("UserData", new UserData());
//		List<UserData> list=userServices.viewUserInfo();
//		return new ModelAndView("updateuserinfo","userList",list);
		return new ModelAndView("updateuserinfo");
	}
	
	@RequestMapping(value="/updateuserinfo", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView updateUserInfo(@ModelAttribute("UserData") UserData userData, BindingResult result)
	{
		userValidater.validate(userData, result);
		if(result.hasErrors())
		{
			return new ModelAndView("updateuserinfo");
		}
		boolean b=userServices.updateUserInfo(userData);
		String msg="Updation is fail ! ";
		if(b==true)
		{
			msg="Updation is success ! ";
		}
		
		return new ModelAndView("updateuserinfo","msg",msg);
	}
	
	@RequestMapping("loginpage")
	public ModelAndView loginPage(Model model)
	{
		model.addAttribute("UserData", new UserData());
		return new ModelAndView("loginuser");
	}
	
	@RequestMapping(value="/loginuser", method=RequestMethod.POST)
	public String loginUser(@ModelAttribute("UserData") UserData userData, RedirectAttributes attributes)
	{
		
		
		userData=userServices.loginUser(userData);
		String page="";
		if(userData==null)
		{
			String msg="Login Fail ! ";
			attributes.addFlashAttribute("msg",msg);
			page="redirect:loginpage.do";
		}
		else
		{
			page="redirect:viewuser.do";
		}
		return page;
	}
	
	@RequestMapping("deleteuserinfo")
	public String deleteUser(@RequestParam("userId") String userId,UserData userData,RedirectAttributes attributes)
	{
		userData.setUserId(Integer.parseInt(userId));
		boolean b=userServices.deleteUserInfo(userData);
		String msg="Data Not Deleted";
		if(b==true)
		{
			msg="Data Deleted";
		}
		attributes.addFlashAttribute("msg",msg);
		return "redirect:viewuser.do";
	}
	
}
