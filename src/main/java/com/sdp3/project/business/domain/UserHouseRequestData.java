package com.sdp3.project.business.domain;

import com.sdp3.project.models.GuestProvider;
import com.sdp3.project.models.House;
import com.sdp3.project.models.HouseRequest;
import com.sdp3.project.models.User;

public class UserHouseRequestData {
	private House house;
	private GuestProvider guestProvider;
	private HouseRequest houseRequests;
	private User users;
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
	public HouseRequest getHouseRequests() {
		return houseRequests;
	}
	public void setHouseRequests(HouseRequest houseRequests) {
		this.houseRequests = houseRequests;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
}
