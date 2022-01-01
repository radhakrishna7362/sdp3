package com.sdp3.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp3.project.models.RejectedHouse;
import com.sdp3.project.repository.RejectedHouseRepository;

@Service
public class RejectedHouseService {

	@Autowired
	private RejectedHouseRepository rejectedHouseRepository;
	
	public void addRejectedHouse(RejectedHouse h) {
		rejectedHouseRepository.save(h);
	}
	
	public void updateRejectedHouse(RejectedHouse h) {
		rejectedHouseRepository.save(h);
	}
	
	public void deleteRejectedHouse(RejectedHouse h) {
		rejectedHouseRepository.delete(h);
	}
	
	public void deleteRejectedHouseById(long id) {
		RejectedHouse h = rejectedHouseRepository.findById(id).get();
		rejectedHouseRepository.delete(h);
	}
	
	public RejectedHouse getRejectedHouseById(long id) {
		return rejectedHouseRepository.findById(id).get();
	}
	
	public List<RejectedHouse> getAllRejectedHouses(){
		return rejectedHouseRepository.findAll();
	}
	
	public List<RejectedHouse> getRejectedHouseByProviderId(long id){
		return (List<RejectedHouse>) rejectedHouseRepository.findByProviderId(id);
	}
}
