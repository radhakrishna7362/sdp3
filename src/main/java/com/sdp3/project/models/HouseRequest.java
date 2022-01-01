package com.sdp3.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HOUSE_REQUEST")
public class HouseRequest {

	@Id
	@Column(name="REQUEST_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="HOUSE_ID")
	private long houseId;
	
	@Column(name="USER_ID")
	private long userId;
	
	@Column(name="PROVIDER_ID")
	private long providerId;
	
	@Column(name="APPROVAL")
	private boolean approval;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getHouseId() {
		return houseId;
	}

	public void setHouseId(long houseId) {
		this.houseId = houseId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getProviderId() {
		return providerId;
	}

	public void setProviderId(long providerId) {
		this.providerId = providerId;
	}
	
	public void setApproval(boolean approval) {
		this.approval = approval;
	}
	
	public boolean getApproval() {
		return approval;
	}
}
