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

import com.sdp3.project.models.GuestProvider;
import com.sdp3.project.service.GuestProviderService;

@Controller
public class GuestProviderController {

	@Autowired
	private GuestProviderService guestProviderService;
	
	@GetMapping("/guest-provider-home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("guest-provider-home");
		return mv;
	}
	
	@GetMapping("/guest-provider-login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("guest-provider-login","guestProvider",new GuestProvider());
		mv.setViewName("guest-provider-login");
		return mv;
	}
	
	@PostMapping("/guest-provider-login")
	public ModelAndView login(@ModelAttribute("guestProvider")GuestProvider guestProvider,HttpSession session) {
		ModelAndView mv;
		if(guestProviderService.validateGuestProvider(guestProvider)) {
			session.setAttribute("userName", guestProvider.getUserName());
			GuestProvider gp = guestProviderService.getGuestProviderByUserName(guestProvider.getUserName());
			session.setAttribute("userId", gp.getId());
			mv = new ModelAndView("redirect:/guest-provider-home");
		}
		else {
			mv = new ModelAndView();
			mv.setViewName("guest-provider-login");
			String msg="Guest Provider Login Failed. Please Try Again";
			mv.addObject("msg",msg);
		}
		return mv;
	}
	
	@GetMapping("/guest-provider-register")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("guest-provider-register","guestProvider",new GuestProvider());
		mv.setViewName("guest-provider-register");
		return mv;
	}
	
	@PostMapping("/guest-provider-register")
	public ModelAndView register(@ModelAttribute("guestProvider")GuestProvider guestProvider, HttpSession session, @RequestParam("file") MultipartFile file) {
		guestProvider.setPassword(passwordEncoder(guestProvider.getPassword()));
		guestProvider.setRole("GUESTPROVIDER");
		guestProvider.setGovernmentIdProof(FileUploadController.upload(file));
		guestProviderService.addGuestProvider(guestProvider);
		ModelAndView mv = new ModelAndView("redirect:/guest-provider-login");
		return mv;
	}
	
	public String passwordEncoder(String password) {
		int strength = 10;
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
		return bCryptPasswordEncoder.encode(password);
	}
	
	@GetMapping("/guest-provider-logout")
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute("userName");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		String msg="LoggedOut Successfully";
		mv.addObject("msg",msg);
		return mv;
	}
	
	@GetMapping("/pending-guest-provider-approvals")
	public ModelAndView PendingGuestProviderApprovals() {
		List<GuestProvider> gp = guestProviderService.getAllPendingApprovals();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pending-guest-provider-approvals");
		mv.addObject("gp",gp);
		return mv;
	}
	
	@GetMapping("/guest-provider-details/{Id}")
	public ModelAndView GuestProviderDetails(@PathVariable("Id")long Id) {
		GuestProvider gp = guestProviderService.getGuestProviderById(Id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("guest-provider-details");
		mv.addObject("gp",gp);
		return mv;
	}
	
	@GetMapping("/guest-provider-approval/{Id}")
	public ModelAndView GuestProviderApproval(@PathVariable("Id")long Id) {
		GuestProvider gp = guestProviderService.getGuestProviderById(Id);
		gp.setApproval(true);
		guestProviderService.updateGuestProvider(gp);
		ModelAndView mv = new ModelAndView("redirect:/admin-home");
		return mv;
	}

}
