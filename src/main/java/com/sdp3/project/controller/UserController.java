package com.sdp3.project.controller;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
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

import com.sdp3.project.models.RejectedUser;
import com.sdp3.project.models.User;
import com.sdp3.project.service.RejectedUserService;
//import com.sdp3.project.service.EmailService;
import com.sdp3.project.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RejectedUserService rejectedUserService;
	
//	@Autowired
//	private EmailService emailService;
	
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
			mv = new ModelAndView("redirect:/guest-houses/"+u.getId());
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
	
	public String generateString() {
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	    return generatedString;
	}
	
	@PostMapping("/register")
	public ModelAndView registrationData(@ModelAttribute("user")User user, @RequestParam("file") MultipartFile file) throws MessagingException  {
		user.setPassword(passwordEncoder(user.getPassword()));
		user.setRole("TRAVELLER");
		user.setApproval(false);
		user.setGovernmentIdProof(FileUploadController.upload(file));
		userService.addUser(user);
//		emailService.sendHtmlMessage(user.getEmail(), "Welcome to FeelHome Family", "<h1>Your Registration is Successful, You will receive a mail of approval in a few hours.</h1>");
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
		ModelAndView mv = new ModelAndView("redirect:/");
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
	
	@GetMapping("/user-reject/{Id}")
	public ModelAndView GuestProviderReject(@PathVariable("Id")long Id) {
		User user = userService.getUserById(Id);
		RejectedUser ru = new RejectedUser();
		ru.setEmail(user.getEmail());
		ru.setFirstName(user.getFirstName());
		ru.setGovernmentId(user.getGovernmentId());
		ru.setGovernmentIdProof(user.getGovernmentIdProof());
		ru.setLastName(user.getLastName());
		ru.setPassword(user.getPassword());
		ru.setPhoneNo(user.getPhoneNo());
		ru.setRole(user.getRole());
		ru.setUserId(Id);
		ru.setUserName(user.getUserName());
		rejectedUserService.addRejectedUser(ru);
		userService.deleteUserById(Id);
		ModelAndView mv = new ModelAndView("redirect:/pending-user-approvals");
		return mv;
	}
}
