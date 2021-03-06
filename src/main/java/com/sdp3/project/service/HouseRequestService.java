package com.sdp3.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp3.project.business.domain.CompletedHouseRequestData;
import com.sdp3.project.business.domain.HouseRequestData;
import com.sdp3.project.business.domain.RejectedHouseRequestData;
import com.sdp3.project.business.domain.UserHouseRequestData;
import com.sdp3.project.models.CompletedHouseRequest;
import com.sdp3.project.models.HouseRequest;
import com.sdp3.project.models.RejectedHouseRequest;
import com.sdp3.project.models.User;
import com.sdp3.project.repository.CompletedHouseRequestRepository;
import com.sdp3.project.repository.GuestProviderRepository;
import com.sdp3.project.repository.HouseRepository;
import com.sdp3.project.repository.HouseRequestRepository;
import com.sdp3.project.repository.RejectedHouseRequestRepository;
import com.sdp3.project.repository.UserRepository;

@Service
public class HouseRequestService {
	
	@Autowired
	private HouseRequestRepository houseRequestRepository;
	@Autowired
	private RejectedHouseRequestRepository rejectedHouseRequestRepository;
	@Autowired
	private CompletedHouseRequestRepository completedHouseRequestRepository;
	@Autowired
	private HouseRepository houseRepository;
	@Autowired
	private GuestProviderRepository guestProviderRepository;
	@Autowired
	private UserRepository userRepository;

	
	public void addHouseRequest(HouseRequest h) {
		houseRequestRepository.save(h);
	}
	
	public void updateHouseRequest(HouseRequest h) {
		houseRequestRepository.save(h);
	}
	
	public void deleteHouseRequest(long id) {
		HouseRequest h = houseRequestRepository.findById(id).get();
		houseRequestRepository.delete(h);
	}
	
	public HouseRequest getHouseRequestById(long id) {
		return houseRequestRepository.findById(id).get();
	}
	
	public List<HouseRequest> getAllRequests(){
		return houseRequestRepository.findAll();
	}
	
	public List<HouseRequest> getAllPendingApprovals(){
		return (List<HouseRequest>) houseRequestRepository.findByApprovalFalse();
	}
	
	public List<HouseRequest> getAllApprovedProviders(){
		return (List<HouseRequest>) houseRequestRepository.findByApprovalTrue();
	}
	
	public List<HouseRequest> getHouseRequestByProviderId(long id) {
		return (List<HouseRequest>) houseRequestRepository.findByProviderId(id);
	}
	
	public List<HouseRequest> getHouseRequestByHouseIdAndProviderId(long houseId,long providerId) {
		return (List<HouseRequest>) houseRequestRepository.findByHouseIdAndProviderId(houseId,providerId);
	}
	
	public HouseRequestData getHouseRequestData(long providerId,long houseId){
		HouseRequestData result = new HouseRequestData();
		List<HouseRequest> houseRequests = getHouseRequestByHouseIdAndProviderId(houseId, providerId);
		if(houseRequests.size()!=0) {
			result.setHouse(houseRepository.findById(houseRequests.get(0).getHouseId()).get());
			result.setGuestProvider(guestProviderRepository.findById(houseRequests.get(0).getProviderId()).get());
			List<User> u = new ArrayList<>();
			List<HouseRequest> hr = new ArrayList<>();
			houseRequests.forEach(houseRequest->{
				u.add(userRepository.findById(houseRequest.getUserId()).get());
				hr.add(houseRequest);
			});
			result.setHouseRequests(hr);
			result.setUsers(u);
		}
		return result;
	}
	
	public RejectedHouseRequestData getRejectedHouseRequestData(long providerId,long houseId){
		RejectedHouseRequestData result = new RejectedHouseRequestData();
		List<RejectedHouseRequest> rejectedHouseRequests = (List<RejectedHouseRequest>) rejectedHouseRequestRepository.findByHouseIdAndProviderId(houseId, providerId);
		if(rejectedHouseRequests.size()!=0) {
			List<User> u = new ArrayList<>();
			List<RejectedHouseRequest> rhr = new ArrayList<>();
			rejectedHouseRequests.forEach(rejectedHouseRequest->{
				u.add(userRepository.findById(rejectedHouseRequest.getUserId()).get());
				rhr.add(rejectedHouseRequest);
			});
			result.setHouse(houseRepository.getById(houseId));
			result.setGuestProvider(guestProviderRepository.getById(rejectedHouseRequests.get(0).getProviderId()));
			result.setRejectedHouseRequests(rhr);
			result.setUsers(u);
		}
		return result;
	}
	
	public CompletedHouseRequestData getCompletedHouseRequestData(long providerId,long houseId){
		CompletedHouseRequestData result = new CompletedHouseRequestData();
		List<CompletedHouseRequest> completedHouseRequests = (List<CompletedHouseRequest>) completedHouseRequestRepository.findByHouseIdAndProviderId(houseId, providerId);
		if(completedHouseRequests.size()!=0) {
			List<User> u = new ArrayList<>();
			List<CompletedHouseRequest> rhr = new ArrayList<>();
			completedHouseRequests.forEach(completedHouseRequest->{
				u.add(userRepository.findById(completedHouseRequest.getUserId()).get());
				rhr.add(completedHouseRequest);
			});
			result.setHouse(houseRepository.getById(houseId));
			result.setGuestProvider(guestProviderRepository.getById(completedHouseRequests.get(0).getProviderId()));
			result.setCompletedHouseRequests(rhr);
			result.setUsers(u);
		}
		return result;
	}

	public void deleteHouseRequestsByHouseId(long houseId) {
		List<HouseRequest> houseRequests = (List<HouseRequest>) houseRequestRepository.findByHouseIdAndApprovalFalse(houseId);
		System.out.println("byee");
		houseRequests.forEach(houseRequest->{
			RejectedHouseRequest rhr = new  RejectedHouseRequest();
			System.out.println(houseRequest.getId());
			rhr.setRequestId(houseRequest.getId());
			rhr.setHouseId(houseRequest.getHouseId());
			rhr.setUserId(houseRequest.getUserId());
			rhr.setProviderId(houseRequest.getProviderId());
			rejectedHouseRequestRepository.save(rhr);
			houseRequestRepository.delete(houseRequest);
		});
	}
	
	public UserHouseRequestData userCurrentStay(long userId) {
		UserHouseRequestData data = new UserHouseRequestData();
		HouseRequest houseRequest = houseRequestRepository.findByUserIdAndApprovalTrue(userId);
		if(houseRequest!=null) {
			data.setHouse(houseRepository.findById(houseRequest.getHouseId()).get());
			data.setHouseRequests(houseRequest);
			data.setGuestProvider(guestProviderRepository.findById(houseRequest.getProviderId()).get());
			data.setUsers(userRepository.findById(userId).get());
			return data;
		}
		return null;
	}

	public void deleteHouseRequestsByUserId(long userId) {
		List<HouseRequest> houseRequests = (List<HouseRequest>) houseRequestRepository.findByUserIdAndApprovalFalse(userId);
		houseRequests.forEach(houseRequest->{
			RejectedHouseRequest rhr = new  RejectedHouseRequest();
			rhr.setRequestId(houseRequest.getId());
			rhr.setHouseId(houseRequest.getHouseId());
			rhr.setUserId(houseRequest.getUserId());
			rhr.setProviderId(houseRequest.getProviderId());
			rejectedHouseRequestRepository.save(rhr);
			houseRequestRepository.delete(houseRequest);
		});
	}
}
