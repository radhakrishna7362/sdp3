package com.sdp3.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp3.project.business.domain.UserHouseData;
import com.sdp3.project.models.CompletedHouseRequest;
import com.sdp3.project.models.GuestProvider;
import com.sdp3.project.models.House;
import com.sdp3.project.models.HouseRequest;
import com.sdp3.project.repository.CompletedHouseRequestRepository;
import com.sdp3.project.repository.GuestProviderRepository;
import com.sdp3.project.repository.HouseRepository;
import com.sdp3.project.repository.HouseRequestRepository;

@Service
public class HouseService {

	@Autowired
	private HouseRepository houseRepository;
	@Autowired
	private GuestProviderRepository guestProviderRepository;
	@Autowired
	private HouseRequestRepository houseRequestRepository;
	@Autowired
	private CompletedHouseRequestRepository completedHouseRequestRepository;
	
	public void addHouse(House h) {
		houseRepository.save(h);
	}
	
	public void updateHouse(House h) {
		houseRepository.save(h);
	}
	
	public void deleteHouse(House h) {
		houseRepository.delete(h);
	}
	
	public void deleteHouseById(long id) {
		House h = houseRepository.findById(id).get();
		houseRepository.delete(h);
	}
	
	public House getHouseById(long id) {
		return houseRepository.findById(id).get();
	}
	
	public List<House> getAllHouses(){
		return houseRepository.findAll();
	}
	
	public List<House> getAllPendingApprovals(){
		List<House> houses = new ArrayList<>();
		Iterable<House> h = houseRepository.findByApprovalFalse();
		h.forEach(house->{
			houses.add(house);
		});
		return houses;
	}
	
	public List<House> getAllApprovedHouses(){
		return (List<House>) houseRepository.findByApprovalTrue();
	}
	
	public List<House> getHouseByProviderId(long id){
		return (List<House>) houseRepository.findByProviderId(id);
	}
	
	public boolean currentStay(long userId) {
		HouseRequest houseRequest = houseRequestRepository.findByUserIdAndApprovalTrue(userId);
		if(houseRequest!=null) {
			return true;
		}
		return false;
	}
	
	public UserHouseData getHouseByUserId(long userId) {
		UserHouseData data = new UserHouseData();
		data.setCurrentStay(false);
		List<GuestProvider> gp = new ArrayList<>();
		List<House> houses = (List<House>) houseRepository.findByAvailabilityTrueAndApprovalTrue();
		List<Boolean> r = new ArrayList<>();
		List<Boolean> pr = new ArrayList<>();
		List<Boolean> cr = new ArrayList<>();
		data.setCurrentStay(currentStay(userId));
		houses.forEach(house->{
			gp.add(guestProviderRepository.findById(house.getProviderId()).get());
			List<HouseRequest> request = (List<HouseRequest>) houseRequestRepository.findByHouseIdAndUserIdAndApprovalTrue(house.getId(), userId);
			if(!request.isEmpty()) {
				r.add(true);
			}
			else {
				r.add(false);
			}
			List<HouseRequest> pRequest = (List<HouseRequest>) houseRequestRepository.findByHouseIdAndUserIdAndApprovalFalse(house.getId(), userId);
			if(!pRequest.isEmpty()) {
				pr.add(true);
			}
			else {
				pr.add(false);
			}
			List<CompletedHouseRequest> cRequest = (List<CompletedHouseRequest>) completedHouseRequestRepository.findByHouseIdAndUserId(house.getId(), userId);
			if(!cRequest.isEmpty()) {
				cr.add(true);
			}
			else {
				cr.add(false);
			}
		});
		data.setGuestProvider(gp);
		data.setHouses(houses);
		data.setIsRequested(r);
		data.setIsPending(pr);
		data.setIsCompleted(cr);
		return data;
	}
	
}
