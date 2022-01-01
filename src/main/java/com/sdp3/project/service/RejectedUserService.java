package com.sdp3.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp3.project.models.RejectedUser;
import com.sdp3.project.repository.RejectedUserRepository;

@Service
public class RejectedUserService {

	@Autowired
	private RejectedUserRepository rejectedUserRepository;
	
	public void addRejectedUser(RejectedUser user) {
		rejectedUserRepository.save(user);
	}
	
	public List<RejectedUser> getAllUsers(){
		List<RejectedUser> users = new ArrayList<>();
		Iterable<RejectedUser> u = rejectedUserRepository.findAll();
		u.forEach(user->{
			users.add(user);
		});
		return users;
	}
	
	public void updateRejectedUser(RejectedUser user) {
		rejectedUserRepository.save(user);
	}
	
	public void deleteRejectedUserById(long id) {
		rejectedUserRepository.deleteById(id);
	}
	
	public RejectedUser getRejectedUserById(long id) {
		return rejectedUserRepository.findById(id).get();
	}
		
	public RejectedUser getRejectedUserByUserName(String userName) {
		return 	rejectedUserRepository.findByuserName(userName);
	}
	
}
