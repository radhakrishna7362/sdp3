package com.sdp3.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdp3.project.models.HouseRequest;

public interface HouseRequestRepository extends JpaRepository<HouseRequest,Long> {
	Iterable<HouseRequest> findByApprovalFalse();
	Iterable<HouseRequest> findByApprovalTrue();
	Iterable<HouseRequest> findByHouseIdAndProviderId(long houseId,long providerId);
	Iterable<HouseRequest> findByProviderId(long providerId);
	Iterable<HouseRequest> findByHouseIdAndApprovalFalse(long houseId);
	Iterable<HouseRequest> findByHouseIdAndUserId(long houseId,long userId);
	Iterable<HouseRequest> findByHouseIdAndUserIdAndApprovalFalse(long houseId,long userId);
	Iterable<HouseRequest> findByHouseIdAndUserIdAndApprovalTrue(long houseId,long userId);
	HouseRequest findByUserIdAndApprovalTrue(long UserId);
	Iterable<HouseRequest> findByUserIdAndApprovalFalse(long userId);
}
