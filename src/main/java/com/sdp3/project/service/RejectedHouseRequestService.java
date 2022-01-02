package com.sdp3.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp3.project.models.RejectedHouseRequest;
import com.sdp3.project.repository.RejectedHouseRequestRepository;

@Service
public class RejectedHouseRequestService {
	@Autowired
	private RejectedHouseRequestRepository rejectedHouseRequestRepository;
	
	public void addHouseRequest(RejectedHouseRequest rejectedHouseRequest) {
		rejectedHouseRequestRepository.save(rejectedHouseRequest);
	}
	
	public List<RejectedHouseRequest> getRequest(long houseId, long userId) {
		return (List<RejectedHouseRequest>) rejectedHouseRequestRepository.findByHouseIdAndUserId(houseId, userId);
	}
}
