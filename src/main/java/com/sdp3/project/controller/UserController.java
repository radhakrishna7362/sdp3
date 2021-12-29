package com.sdp3.project.controller;

import java.security.SecureRandom;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sdp3.project.models.User;
//import com.sdp3.project.service.EmailService;
import com.sdp3.project.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private EmailService emailService;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login","user",new User());
		mv.setViewName("user_login");
		return mv;
	}
	
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute("user")User user,HttpSession session) {
		ModelAndView mv;
		if(userService.validateUser(user)) {
			session.setAttribute("userName", user.getUserName());
			User u = userService.getUserByUserName(user.getUserName());
			session.setAttribute("userId", u.getId());
			mv = new ModelAndView("redirect:/user-home");
		}
		else{
			mv = new ModelAndView();
			mv.setViewName("user_login");
			String msg = "Login Failed. Please Try Again";
			mv.addObject("msg",msg);
		}
		return mv;
	}
	
	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("registration","user",new User());
		mv.setViewName("user_registration");
		return mv;
	}
	
	@PostMapping("/register")
	public ModelAndView registrationData(@ModelAttribute("user")User user, @RequestParam("file") MultipartFile file) {
		user.setPassword(passwordEncoder(user.getPassword()));
		user.setRole("TRAVELLER");
		user.setApproval(false);
		user.setGovernmentIdProof(FileUploadController.upload(file));
		userService.addUser(user,file);
//		emailService.sendSimpleMessage(user.getEmail(), "Welcome to FeelHome Family", "Your Registration is Successful, You will receive a mail of approval in a few hours.");
		ModelAndView mv = new ModelAndView("redirect:/login");
		return mv;
		
	}
	public String passwordEncoder(String password) {
		int strength = 10;
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
		return bCryptPasswordEncoder.encode(password);
	}
	
	@GetMapping("/user-home")
	public ModelAndView home() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user_home");
		return mv;
	}
	
	@GetMapping("/user-logout")
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute("userName");
		session.removeAttribute("userId");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		String msg="LoggedOut Successfully";
		mv.addObject("msg",msg);
		return mv;
	}
	
	@GetMapping("/user-profile/{id}")
	public ModelAndView profile(@PathVariable("id")long id) {
		User user = userService.getUserById(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user_profile");
		mv.addObject("user",user);
		return mv;
	}
	
	@GetMapping("/edit-user-profile/{id}")
	public ModelAndView editProfile(@PathVariable("id") long id) {
		User user = userService.getUserById(id);
		ModelAndView mv = new ModelAndView("updateprofile","user",user);
		mv.setViewName("user_update_profile");
		mv.addObject("user",user);
		return mv;
	}

	@PostMapping("/user-profile-update")
	public String updateProfile(@ModelAttribute("user")User user) {
		userService.updateUser(user);
		return "redirect:/user-profile/"+user.getId();
	}
	
	@GetMapping("/pending-user-approvals")
	public ModelAndView PendingUserApprovals() {
		List<User> users = userService.getAllPendingApprovals();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pending-user-approvals");
		mv.addObject("users",users);
		return mv;
	}
	
	
	@GetMapping("/user-details/{Id}")
	public ModelAndView GuestProviderDetails(@PathVariable("Id")long Id) {
		User user = userService.getUserById(Id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user-details");
		mv.addObject("user",user);
		return mv;
	}
	
	@GetMapping("/user-approval/{Id}")
	public ModelAndView GuestProviderApproval(@PathVariable("Id")long Id) {
		User user = userService.getUserById(Id);
		user.setApproval(true);
		userService.updateUser(user);
		ModelAndView mv = new ModelAndView("redirect:/admin-home");
		return mv;
	}
}
