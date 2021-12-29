package com.sdp3.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sdp3.project.models.User;
import com.sdp3.project.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void addUser(User user, MultipartFile file) {
		userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		Iterable<User> u = userRepository.findAll();
		u.forEach(user->{
			users.add(user);
		});
		return users;
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUserById(long id) {
		userRepository.deleteById(id);
	}
	
	public User getUserById(long id) {
		return userRepository.findById(id).get();
	}
	
	public boolean validateUser(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		User u = userRepository.findByuserName(user.getUserName());
		if(u==null) {
			return false;
		}
//		return u.isApproval() && passwordEncoder.matches(user.getPassword(), u.getPassword());
		return passwordEncoder.matches(user.getPassword(), u.getPassword());
	}
	
	public User getUserByUserName(String userName) {
		return 	userRepository.findByuserName(userName);
	}
	
	public List<User> getAllPendingApprovals(){
		List<User> u = new ArrayList<>();
		Iterable<User> users = userRepository.findByApprovalFalse();
		users.forEach(user->{
			u.add(user);
		});
		return u;
	}
	
	public List<User> getAllApprovedUsers(){
		List<User> u = new ArrayList<>();
		Iterable<User> users = userRepository.findByApprovalTrue();
		users.forEach(user->{
			u.add(user);
		});
		return u;
	}

}
