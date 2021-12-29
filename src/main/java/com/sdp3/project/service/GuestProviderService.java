package com.sdp3.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sdp3.project.models.GuestProvider;
import com.sdp3.project.repository.GuestProviderRepository;

@Service
public class GuestProviderService {
	@Autowired
	private GuestProviderRepository guestProviderRepository;
	
	public void addGuestProvider(GuestProvider guestProvider) {
		guestProviderRepository.save(guestProvider);
	}
	
	public void updateGuestProvider(GuestProvider guestProvider) {
		guestProviderRepository.save(guestProvider);
	}
	
	public void deleteGuestProvider(long id) {
		guestProviderRepository.deleteById(id);
	}
	
	public GuestProvider getGuestProviderById(long id) {
		return guestProviderRepository.findById(id).get();
	}
	
	public boolean validateGuestProvider(GuestProvider guestProvider) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		GuestProvider gp = guestProviderRepository.findByuserName(guestProvider.getUserName());
		if(gp==null) {
			return false;
		}
//		return gp.isApproval() && passwordEncoder.matches(guestProvider.getPassword(), gp.getPassword());
		return passwordEncoder.matches(guestProvider.getPassword(), gp.getPassword());
	}	

	public List<GuestProvider> getAllPendingApprovals(){
		List<GuestProvider> guestProvider = new ArrayList<>();
		Iterable<GuestProvider> gp = guestProviderRepository.findByApprovalFalse();
		gp.forEach(g->{
			guestProvider.add(g);
		});
		return guestProvider;
	}
	
	public List<GuestProvider> getAllApprovedProviders(){
		return (List<GuestProvider>) guestProviderRepository.findByApprovalTrue();
	}
	
	public GuestProvider getGuestProviderByUserName(String userName) {
		return guestProviderRepository.findByuserName(userName);
	}
}
