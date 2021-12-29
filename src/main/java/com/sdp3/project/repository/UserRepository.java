package com.sdp3.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdp3.project.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	User findByuserName(String userName);
	Iterable<User> findByApprovalFalse();
	Iterable<User> findByApprovalTrue();
}
