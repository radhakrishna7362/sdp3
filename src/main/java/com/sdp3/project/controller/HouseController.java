package com.sdp3.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sdp3.project.models.House;
import com.sdp3.project.service.HouseService;

@Controller
public class HouseController {

	@Autowired
	private HouseService houseService;
	
	@GetMapping("/add-guest-house")
	public ModelAndView addHouse() {
		ModelAndView mv= new ModelAndView("add_house","house",new House());
		mv.setViewName("add-guest-house");
		return mv;
	}
	
	@PostMapping("/add-guest-house")
	public ModelAndView addHouse(@ModelAttribute("house") House h, @RequestParam("file") MultipartFile file, @RequestParam("img1") MultipartFile img1,
			@RequestParam("img2") MultipartFile img2, @RequestParam("img3") MultipartFile img3, @RequestParam("img4") MultipartFile img4, @RequestParam("img5") MultipartFile img5) {
		h.setAvailability(true);
		h.setApproval(false);
		h.setHouseProof(FileUploadController.upload(file));
		h.setImage1(FileUploadController.upload(img1));
		h.setImage2(FileUploadController.upload(img2));
		h.setImage3(FileUploadController.upload(img3));
		h.setImage4(FileUploadController.upload(img4));
		h.setImage5(FileUploadController.upload(img5));
		houseService.addHouse(h);
		ModelAndView mv = new ModelAndView("redirect:/guest-provider-home");
		return mv;
	}
	
	@GetMapping("/pending-house-approvals")
	public ModelAndView pendingHouseApprovals() {
		List<House> houses = houseService.getAllPendingApprovals();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pending-house-approvals");
		mv.addObject("houses",houses);
		return mv;
	}

	@GetMapping("/house-details/{Id}")
	public ModelAndView GuestProviderDetails(@PathVariable("Id")long Id) {
		House house = houseService.getHouseById(Id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("house-details");
		mv.addObject("house",house);
		return mv;
	}
	
	@GetMapping("/house-approval/{Id}")
	public ModelAndView GuestProviderApproval(@PathVariable("Id")long Id) {
		House house = houseService.getHouseById(Id);
		house.setApproval(true);
		houseService.updateHouse(house);
		ModelAndView mv = new ModelAndView("redirect:/pending-house-approvals");
		return mv;
	}
	
	@GetMapping("/guest-houses")
	public ModelAndView GuestHouses() {
		List<House> houses = houseService.getAllApprovedHouses();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("guest-houses");
		mv.addObject("houses",houses);
		return mv;
	}
	
	@GetMapping("/guest-provider-houses/{Id}")
	public ModelAndView GuestProviderHouses(@PathVariable("Id") long Id) {
		List<House> houses = houseService.getHouseByProviderId(Id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("guest-provider-houses");
		mv.addObject("houses",houses);
		return mv;
	}

}
