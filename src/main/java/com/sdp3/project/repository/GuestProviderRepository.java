package com.sdp3.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdp3.project.models.GuestProvider;

public interface GuestProviderRepository extends JpaRepository<GuestProvider, Long> {
	GuestProvider findByuserName(String userName);
	Iterable<GuestProvider> findByApprovalFalse();
	Iterable<GuestProvider> findByApprovalTrue();
}
