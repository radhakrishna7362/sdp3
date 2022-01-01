package com.sdp3.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp3.project.models.CompletedHouseRequest;
import com.sdp3.project.repository.CompletedHouseRequestRepository;

@Service
public class CompletedHouseRequestService {
	@Autowired
	private CompletedHouseRequestRepository completedHouseRequestRepository;
	
	public void addHouseRequest(CompletedHouseRequest completedHouseRequest) {
		completedHouseRequestRepository.save(completedHouseRequest);
	}
	
	public List<CompletedHouseRequest> getRequest(long houseId, long userId) {
		return (List<CompletedHouseRequest>) completedHouseRequestRepository.findByHouseIdAndUserId(houseId, userId);
	}
}
