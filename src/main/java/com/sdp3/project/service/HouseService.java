package com.sdp3.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp3.project.models.House;
import com.sdp3.project.repository.HouseRepository;

@Service
public class HouseService {

	@Autowired
	private HouseRepository houseRepository;
	
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
}
