package com.sdp3.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdp3.project.models.CompletedHouseRequest;

public interface CompletedHouseRequestRepository extends JpaRepository<CompletedHouseRequest,Long> {
	Iterable<CompletedHouseRequest> findByHouseIdAndProviderId(long houseId,long providerId);
	Iterable<CompletedHouseRequest> findByProviderId(long providerId);
	Iterable<CompletedHouseRequest> findByHouseIdAndUserId(long houseId,long userId);
}
