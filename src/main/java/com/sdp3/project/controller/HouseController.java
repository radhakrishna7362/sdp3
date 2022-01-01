package com.sdp3.project.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sdp3.project.business.domain.HouseRequestData;
import com.sdp3.project.business.domain.RejectedHouseRequestData;
import com.sdp3.project.business.domain.UserHouseData;
import com.sdp3.project.business.domain.UserHouseRequestData;
import com.sdp3.project.models.Comment;
import com.sdp3.project.models.CompletedHouseRequest;
import com.sdp3.project.models.House;
import com.sdp3.project.models.HouseRequest;
import com.sdp3.project.models.Rating;
import com.sdp3.project.models.RejectedHouse;
import com.sdp3.project.service.CommentService;
import com.sdp3.project.service.CompletedHouseRequestService;
import com.sdp3.project.service.HouseRequestService;
import com.sdp3.project.service.HouseService;
import com.sdp3.project.service.RatingService;
import com.sdp3.project.service.RejectedHouseService;

@Controller
public class HouseController {

	@Autowired
	private HouseService houseService;
	@Autowired
	private RejectedHouseService rejectedHouseService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private HouseRequestService houseRequestService;
	@Autowired
	private CompletedHouseRequestService completedHouseRequestService;
	@Autowired
	private RatingService ratingService;
	
	@GetMapping("/add-guest-house")
	public ModelAndView addHouse() {
		ModelAndView mv= new ModelAndView("add_house","house",new House());
		mv.setViewName("add-guest-house");
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
	
	@PostMapping("/add-guest-house")
	public ModelAndView addHouse(@ModelAttribute("house") House h, @RequestParam("file") MultipartFile file, @RequestParam("img1") MultipartFile img1,
			@RequestParam("img2") MultipartFile img2, @RequestParam("img3") MultipartFile img3, @RequestParam("img4") MultipartFile img4, @RequestParam("img5") MultipartFile img5,@RequestParam("vid") MultipartFile vid,HttpSession session) {
		h.setAvailability(true);
		h.setApproval(false);
		h.setHouseProof(FileUploadController.upload(file));
		h.setImage1(FileUploadController.upload(img1));
		h.setImage2(FileUploadController.upload(img2));
		h.setImage3(FileUploadController.upload(img3));
		h.setImage4(FileUploadController.upload(img4));
		h.setImage5(FileUploadController.upload(img5));
		h.setVideoProof(FileUploadController.upload(vid));
		houseService.addHouse(h);
		long id = (long)session.getAttribute("userId");
		ModelAndView mv = new ModelAndView("redirect:/guest-provider-houses/"+id);
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
	
	@GetMapping("/house-reject/{Id}")
	public ModelAndView GuestHouseReject(@PathVariable("Id") long Id) {
		House house = houseService.getHouseById(Id);
		RejectedHouse rh = new RejectedHouse();
		rh.setHouseId(house.getId());
		rh.setHouseNo(house.getHouseNo());
		rh.setHouseArea(house.getHouseArea());
		rh.setHouseCity(house.getHouseCity());
		rh.setHouseProof(house.getHouseProof());
		rh.setHouseState(house.getHouseState());
		rh.setHouseType(house.getHouseType());
		rejectedHouseService.addRejectedHouse(rh);
		houseService.deleteHouse(house);
		ModelAndView mv = new ModelAndView("/pending-house-approvals");
		return mv;
	}
	
	@GetMapping("/guest-houses/{Id}")
	public ModelAndView GuestHousesByUserId(@PathVariable("Id") long id) {
		UserHouseData data = houseService.getHouseByUserId(id);
//		System.out.println(data.getHouses().size());
//		System.out.println(data.getIsRequested().get(0));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user-guest-houses");
		mv.addObject("userHouseData",data);
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
	
	@GetMapping("/add-house-request/{Id}")
	public ModelAndView AddHouseRequest(@PathVariable("Id") long Id, HttpSession session) {
		House house = houseService.getHouseById(Id);
		HouseRequest h = new HouseRequest();
		String userId = String.valueOf((long) session.getAttribute("userId"));
		h.setUserId((long)session.getAttribute("userId"));
		h.setHouseId(house.getId());
		h.setProviderId(house.getProviderId());
		h.setApproval(false);
		houseRequestService.addHouseRequest(h);
		ModelAndView mv = new ModelAndView("redirect:/guest-houses/"+userId);
		return mv;
	}

	@GetMapping("/guest-provider-house-requests/{Id}")
	public ModelAndView GuestProviderHouseRequests(@PathVariable("Id") long houseId, HttpSession session) {
		long providerId = (long)session.getAttribute("userId");
		HouseRequestData data = houseRequestService.getHouseRequestData(providerId, houseId);
		RejectedHouseRequestData rejectedData = houseRequestService.getRejectedHouseRequestData(providerId, houseId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("guest-provider-requests");
		mv.addObject("houseRequestData", data);
		mv.addObject("rejectedHouseRequestData",rejectedData);
		return mv;
	}
	
	@GetMapping("/accept-house-request/{requestId}")
	public ModelAndView AcceptHouseRequest(@PathVariable("requestId") long requestId) {
		HouseRequest request = houseRequestService.getHouseRequestById(requestId);
		House house = houseService.getHouseById(request.getHouseId());
		house.setAvailability(false);
		request.setApproval(true);
		houseService.updateHouse(house);
		houseRequestService.updateHouseRequest(request);
		houseRequestService.deleteHouseRequestsByHouseId(request.getHouseId());
		houseRequestService.deleteHouseRequestsByUserId(request.getUserId());
		ModelAndView mv = new ModelAndView("redirect:/guest-provider-house-requests/"+request.getHouseId());
		return mv;
	}
	
	@GetMapping("/user-house-requests/{Id}")
	public ModelAndView UserHouseRequests(@PathVariable("Id") long userId) {
		UserHouseRequestData data = houseRequestService.userCurrentStay(userId);
		boolean currentStay;
		if(data==null) {
			currentStay=false;
		}
		else {
			currentStay=true;
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user-house-requests");
		mv.addObject("userHouseRequestData",data);
		mv.addObject("currentStay",currentStay);
		return mv;
	}
	
	@GetMapping("/end-stay/{Id}")
	public ModelAndView EndStay(@PathVariable("Id") long Id) {
		HouseRequest houseRequest = houseRequestService.getHouseRequestById(Id);
		House house = houseService.getHouseById(houseRequest.getHouseId());
		house.setAvailability(true);
		CompletedHouseRequest ch = new CompletedHouseRequest();
		ch.setHouseId(house.getId());
		ch.setProviderId(house.getProviderId());
		ch.setRequestId(Id);
		ch.setUserId(houseRequest.getUserId());
		houseService.updateHouse(house);
		completedHouseRequestService.addHouseRequest(ch);
		houseRequestService.deleteHouseRequest(Id);
		ModelAndView mv = new ModelAndView("redirect:/provide-feedback/"+house.getId());
		return mv;
	}
	
	@GetMapping("/view-guest-house/{Id}")
	public ModelAndView ViewGuestHouses(@PathVariable("Id") long houseId, HttpSession session) {
		House house = houseService.getHouseById(houseId);
		long userId = (long) session.getAttribute("userId");
		boolean hasStayed=false;
		List<CompletedHouseRequest> completedHouseRequests = completedHouseRequestService.getRequest(houseId, userId);
		if(completedHouseRequests.size()>0) {
			hasStayed = true;
		}
		List<Comment> comments = commentService.getCommentsByHouseId(houseId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view-guest-house");
		mv.addObject("comments", comments);
		mv.addObject("hasStayed",hasStayed);
		mv.addObject("house",house);
		return mv;
	}
	
	@PostMapping("/add-comment/{Id}")
	public ModelAndView AddComment(@ModelAttribute("comment")Comment comment,@RequestParam("file") MultipartFile file,@PathVariable("Id") long houseId, HttpSession session) {
		comment.setHouseId(houseId);
		String userId = String.valueOf((long) session.getAttribute("userId"));
		comment.setUserId((long) session.getAttribute("userId"));
		commentService.addComment(comment);
		ModelAndView mv = new ModelAndView("redirect:/guest-houses/"+userId);
		return mv;
	}
	
	@GetMapping("/add-comment/{Id}")
	public ModelAndView AddComment(@RequestParam("commentMsg")String commentMsg,@PathVariable("Id")long houseId, HttpSession session) {
		Comment comment = new Comment();
		comment.setCommentMsg(commentMsg);
		comment.setHouseId(houseId);
		comment.setUserId((long) session.getAttribute("userId"));
		commentService.addComment(comment);
		ModelAndView mv = new ModelAndView("redirect:/view-guest-house/"+houseId);
		return mv;
	}
	
	@GetMapping("/provide-feedback/{Id}")
	public ModelAndView SubmitFeedback(@PathVariable("Id") long houseId) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("feedback-rating");
		mv.addObject("houseId",houseId);
		return mv;
	}
	
	@GetMapping("/submit-feedback/{Id}")
	public ModelAndView UpdateRating(@PathVariable("Id") long houseId, @RequestParam("rating") int rating, HttpSession session) {
		long id = (long) session.getAttribute("userId");
		String userId = String.valueOf(id);
		Rating rate = new Rating();
		rate.setHouseId(houseId);
		rate.setUserId(id);
		rate.setRating(rating);
		ratingService.addRating(rate);
		House h = houseService.getHouseById(houseId);
		List<Rating> allRating = ratingService.getRatingByHouseId(houseId);
		int val=0,n=0;
		if(!allRating.isEmpty()) {
			n = allRating.size();
			for(int i=0;i<n;i++) {
				val+=allRating.get(i).getRating();
			}
		}
		if(val!=0 && n!=0) {
			float finalRate = ((float)val)/n;
			h.setRating(finalRate);
			houseService.updateHouse(h);
		}
		ModelAndView mv = new ModelAndView("redirect:/guest-houses/"+userId);
		return mv;
	}
}
