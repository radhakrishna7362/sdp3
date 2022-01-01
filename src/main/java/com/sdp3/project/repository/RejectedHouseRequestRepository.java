package com.sdp3.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdp3.project.models.RejectedHouseRequest;

public interface RejectedHouseRequestRepository extends JpaRepository<RejectedHouseRequest,Long> {
	Iterable<RejectedHouseRequest> findByHouseId(long houseId);
	Iterable<RejectedHouseRequest> findByHouseIdAndProviderId(long houseId,long providerId);
}
