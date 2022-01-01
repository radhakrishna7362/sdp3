package com.sdp3.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdp3.project.models.RejectedHouse;

public interface RejectedHouseRepository extends JpaRepository<RejectedHouse,Long> {
	Iterable<RejectedHouse> findByProviderId(long Id);
}
