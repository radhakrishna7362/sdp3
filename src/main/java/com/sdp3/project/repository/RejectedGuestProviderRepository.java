package com.sdp3.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdp3.project.models.RejectedGuestProvider;

public interface RejectedGuestProviderRepository extends JpaRepository<RejectedGuestProvider, Long> {
	RejectedGuestProvider findByuserName(String userName);
}
