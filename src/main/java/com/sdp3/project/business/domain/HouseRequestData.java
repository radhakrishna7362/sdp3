package com.sdp3.project.business.domain;

import java.util.ArrayList;
import java.util.List;

import com.sdp3.project.models.GuestProvider;
import com.sdp3.project.models.House;
import com.sdp3.project.models.HouseRequest;
import com.sdp3.project.models.User;

public class HouseRequestData {
	private House house;
	private GuestProvider guestProvider;
	private List<HouseRequest> houseRequests;
	private List<User> users;
	
	public HouseRequestData() {
		this.house = new House();
		this.guestProvider = new GuestProvider();
		this.houseRequests = new ArrayList<>();
		this.users = new ArrayList<>();
	}
	
	public List<User> getUsers() {
		return users;
	}
	public List<HouseRequest> getHouseRequests() {
		return houseRequests;
	}
	public void setHouseRequests(List<HouseRequest> houseRequests) {
		this.houseRequests = houseRequests;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public GuestProvider getGuestProvider() {
		return guestProvider;
	}
	public void setGuestProvider(GuestProvider guestProvider) {
		this.guestProvider = guestProvider;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
}
