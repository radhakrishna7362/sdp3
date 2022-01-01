package com.sdp3.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp3.project.business.domain.UserHouseData;
import com.sdp3.project.models.CompletedHouseRequest;
import com.sdp3.project.models.House;
import com.sdp3.project.models.HouseRequest;
import com.sdp3.project.repository.CompletedHouseRequestRepository;
import com.sdp3.project.repository.HouseRepository;
import com.sdp3.project.repository.HouseRequestRepository;

@Service
public class HouseService {

	@Autowired
	private HouseRepository houseRepository;
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
	
	public UserHouseData getHouseByUserId(long userId) {
		UserHouseData data = new UserHouseData();
		data.setCurrentStay(false);
		List<House> houses = getAllApprovedHouses();
		List<Boolean> r = new ArrayList<>();
		List<Boolean> pr = new ArrayList<>();
		List<Boolean> cr = new ArrayList<>();
		houses.forEach(house->{
			List<HouseRequest> request = (List<HouseRequest>) houseRequestRepository.findByHouseIdAndUserIdAndApprovalTrue(house.getId(), userId);
			if(request.size()!=0) {
				r.add(true);
				data.setCurrentStay(true);
			}
			else {
				r.add(false);
			}
			List<HouseRequest> pRequest = (List<HouseRequest>) houseRequestRepository.findByHouseIdAndUserIdAndApprovalFalse(house.getId(), userId);
			if(pRequest.size()!=0) {
				pr.add(true);
			}
			else {
				pr.add(false);
			}
			List<CompletedHouseRequest> cRequest = (List<CompletedHouseRequest>) completedHouseRequestRepository.findByHouseIdAndUserId(house.getId(), userId);
			if(cRequest.size()!=0) {
				cr.add(true);
			}
			else {
				cr.add(false);
			}
		});
		data.setHouses(houses);
		data.setIsRequested(r);
		data.setIsPending(pr);
		data.setIsCompleted(cr);
		return data;
	}
	
}
