package com.sdp3.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdp3.project.models.RejectedUser;

@Repository
public interface RejectedUserRepository extends JpaRepository<RejectedUser,Long> {
	RejectedUser findByuserName(String userName);
}
