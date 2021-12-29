package com.sdp3.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sdp3.project.models.GuestProvider;
import com.sdp3.project.models.User;
import com.sdp3.project.service.GuestProviderService;
import com.sdp3.project.service.UserService;

@Controller
public class AdminController {
	
	private GuestProviderService guestProviderService;
	private UserService userService;
	
	@Autowired
	public AdminController(GuestProviderService guestProviderService,UserService userService) {
		this.guestProviderService = guestProviderService;
		this.userService = userService;
	}
	@GetMapping("/admin-login")
	public ModelAndView AdminLogin() {
		ModelAndView mv = new ModelAndView("admin-login","user",new User());
		mv.setViewName("admin-login");
		return mv;
	}
	
	@PostMapping("/admin-login")
	public ModelAndView AdminLogin(@ModelAttribute("user")User user,HttpSession session) {
		ModelAndView mv;
		if(user.getUserName().equals("admin") && user.getPassword().equals("admin")) {
			session.setAttribute("userName", "admin");
			mv = new ModelAndView("redirect:/admin-home");
		}
		else {
			mv = new ModelAndView();
			mv.setViewName("admin-login");
			String msg="Admin Login Failed. Please Try Again";
			mv.addObject("msg",msg);
		}
		return mv;
	}
	
	@GetMapping("/admin-logout")
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute("userName");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		String msg = "LoggedOut Successfully";
		mv.addObject("msg",msg);
		return mv;
	}
	
	@GetMapping("/admin-home")
	public ModelAndView AdminHome() {
		ModelAndView mv = new ModelAndView();
		List<GuestProvider> gp = guestProviderService.getAllApprovedProviders();
		List<User> users = userService.getAllApprovedUsers();
		mv.addObject("users",users);
		mv.addObject("gp",gp);
		mv.setViewName("admin-home");
		return mv;
	}
	
}
