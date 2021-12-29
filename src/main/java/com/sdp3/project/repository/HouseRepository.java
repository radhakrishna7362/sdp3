package com.sdp3.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdp3.project.models.House;

public interface HouseRepository extends JpaRepository<House,Long> {
	Iterable<House> findByApprovalFalse();
	Iterable<House> findByApprovalTrue();
	Iterable<House> findByProviderId(long Id);
}
