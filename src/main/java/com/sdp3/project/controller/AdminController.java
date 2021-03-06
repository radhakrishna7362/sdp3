package com.sdp3.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.sdp3.project.business.domain.Result;
import com.sdp3.project.models.GuestProvider;
import com.sdp3.project.models.House;
import com.sdp3.project.models.User;
import com.sdp3.project.service.GuestProviderService;
import com.sdp3.project.service.HouseService;
import com.sdp3.project.service.UserService;

@Controller
public class AdminController {
	
	private GuestProviderService guestProviderService;
	private UserService userService;
	private HouseService houseService;
	@Autowired
	public AdminController(GuestProviderService guestProviderService,UserService userService,HouseService houseService) {
		this.guestProviderService = guestProviderService;
		this.userService = userService;
		this.houseService = houseService;
	}
	@GetMapping("/admin-login")
	public ModelAndView AdminLogin() {
		ModelAndView mv = new ModelAndView("admin-login","user",new User());
		mv.setViewName("admin-login");
		return mv;
	}
	
	@GetMapping("/test")
	public ModelAndView test() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("test.html");
		return mv;
	}
	
	@PostMapping("/test")
	public ModelAndView Hiitest(@RequestParam("username")String UserName, @RequestParam("password")String Password, RestTemplate restTemplate) {
		System.out.println(UserName);
		System.out.println(Password);
		
		Result result = restTemplate.getForObject("https://akira-rest-api.herokuapp.com/getMetaData/"+UserName+"/"+Password+"/?format=json", Result.class);
		System.out.println(result.getMetaKey());
//		System.out.println(result);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success.html");
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
		ModelAndView mv = new ModelAndView("redirect:/");
		return mv;
	}
	
	@GetMapping("/admin-home")
	public ModelAndView AdminHome() {
		ModelAndView mv = new ModelAndView();
		List<GuestProvider> gp = guestProviderService.getAllApprovedProviders();
		List<User> users = userService.getAllApprovedUsers();
		List<House> houses = houseService.getAllApprovedHouses();
		mv.addObject("users",users);
		mv.addObject("gp",gp);
		mv.addObject("houses",houses);
		mv.setViewName("admin-home");
		return mv;
	}
	
}
