package com.sdp3.project.business.domain;

import java.util.ArrayList;
import java.util.List;

import com.sdp3.project.models.RejectedHouseRequest;
import com.sdp3.project.models.User;

public class RejectedHouseRequestData {
	private List<RejectedHouseRequest> rejectedHouseRequests;
	private List<User> users;
	
	public List<User> getUsers() {
		return users;
	}
	public List<RejectedHouseRequest> getRejectedHouseRequests() {
		return rejectedHouseRequests;
	}
	public void setRejectedHouseRequests(List<RejectedHouseRequest> rejectedHouseRequests) {
		this.rejectedHouseRequests = rejectedHouseRequests;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public RejectedHouseRequestData() {
		this.rejectedHouseRequests = new ArrayList<>();
		this.users = new ArrayList<>();
	}
	public RejectedHouseRequestData(List<RejectedHouseRequest> rejectedHouseRequests, List<User> users) {
		super();
		this.rejectedHouseRequests = rejectedHouseRequests;
		this.users = users;
	}
}
