package com.sdp3.project.controller;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

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
import com.sdp3.project.models.RejectedGuestProvider;
import com.sdp3.project.service.GuestProviderService;
import com.sdp3.project.service.RejectedGuestProviderService;

@Controller
public class GuestProviderController {

	@Autowired
	private GuestProviderService guestProviderService;
	@Autowired
	private RejectedGuestProviderService rejectedGuestProviderService;
	
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
			mv = new ModelAndView("redirect:/guest-provider-houses/"+gp.getId());
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
		ModelAndView mv = new ModelAndView("redirect:/");
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
	
	@GetMapping("/guest-provider-reject/{Id}")
	public ModelAndView GuestProviderReject(@PathVariable("Id")long Id) {
		GuestProvider gp = guestProviderService.getGuestProviderById(Id);
		RejectedGuestProvider rgp = new RejectedGuestProvider();
		rgp.setAddress(gp.getAddress());
		rgp.setAddressProof(gp.getAddressProof());
		rgp.setEmail(gp.getEmail());
		rgp.setFirstName(gp.getFirstName());
		rgp.setGovernmentId(gp.getGovernmentId());
		rgp.setGovernmentIdProof(gp.getGovernmentIdProof());
		rgp.setGuestProviderId(Id);
		rgp.setLastName(gp.getLastName());
		rgp.setPassword(gp.getPassword());
		rgp.setPhoneNo(gp.getPhoneNo());
		rgp.setRole(gp.getRole());
		rgp.setUserName(gp.getUserName());
		rejectedGuestProviderService.addRejectedGuestProvider(rgp);
		guestProviderService.deleteGuestProvider(Id);
		ModelAndView mv = new ModelAndView("redirect:/pending-guest-provider-approvals");
		return mv;
	}
	
	@GetMapping("/guest-provider-profile/{Id}")
	public ModelAndView GuestProviderProfile(@PathVariable("Id")long Id) {
		System.out.println("Hii");
		GuestProvider gp = guestProviderService.getGuestProviderById(Id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("guest_provider_profile");
		mv.addObject("gp",gp);
		return mv;
	}
	
	@GetMapping("/edit-guest-provider-profile/{Id}")
	public ModelAndView GuestProviderUpdateProfile(@PathVariable("Id")long Id) {
		GuestProvider gp = guestProviderService.getGuestProviderById(Id);
		ModelAndView mv = new ModelAndView("guestProvider","guestProvider",gp);
		mv.setViewName("guest-provider-update-profile");
		mv.addObject("gp",gp);
		return mv;
	}
	
	@PostMapping("/guest-provider-profile-update")
	public ModelAndView UpdateProfile(@ModelAttribute("guestProvider") GuestProvider gp) {
		System.out.println(gp.getId());
		GuestProvider guestProvider = guestProviderService.getGuestProviderById(gp.getId());
		guestProvider.setEmail(gp.getEmail());
		guestProvider.setPhoneNo(gp.getPhoneNo());
		guestProvider.setFirstName(gp.getFirstName());
		guestProvider.setLastName(gp.getLastName());
		guestProvider.setAddress(gp.getAddress());
		guestProviderService.updateGuestProvider(guestProvider);
		ModelAndView mv = new ModelAndView("redirect:/guest-provider-profile/"+guestProvider.getId());
		return mv;
	}
}
