package com.sdp3.project.business.domain;

import java.util.ArrayList;
import java.util.List;

import com.sdp3.project.models.CompletedHouseRequest;
import com.sdp3.project.models.GuestProvider;
import com.sdp3.project.models.House;
import com.sdp3.project.models.User;

public class CompletedHouseRequestData {
	private House house;
	private GuestProvider guestProvider;
	private List<CompletedHouseRequest> completedHouseRequests;
	private List<User> users;
	
	public List<User> getUsers() {
		return users;
	}
	public CompletedHouseRequestData() {
		this.completedHouseRequests = new ArrayList<>();
		this.users = new ArrayList<>();
	}
	public CompletedHouseRequestData(List<CompletedHouseRequest> completedHouseRequests, List<User> users) {
		super();
		this.completedHouseRequests = completedHouseRequests;
		this.users = users;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	public GuestProvider getGuestProvider() {
		return guestProvider;
	}
	public void setGuestProvider(GuestProvider guestProvider) {
		this.guestProvider = guestProvider;
	}
	public List<CompletedHouseRequest> getCompletedHouseRequests() {
		return completedHouseRequests;
	}
	public void setCompletedHouseRequests(List<CompletedHouseRequest> completedHouseRequests) {
		this.completedHouseRequests = completedHouseRequests;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
