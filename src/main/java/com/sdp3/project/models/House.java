package com.sdp3.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HOUSE")
public class House {
	@Id
	@Column(name="HOUSE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="PROVIDER_ID")
	private long providerId;

	@Column(name="HOUSE_TYPE")
	private String houseType;
	
	@Column(name="HOUSE_CITY")
	private String houseCity;
	
	@Column(name="HOUSE_STATE")
	private String houseState;
	
	@Column(name="HOUSE_AREA")
	private String houseArea;
	
	@Column(name="HOUSE_NO")
	private String houseNo;
	
	@Column(name="HOUSE_PROOF")
	private String houseProof;
	
	@Column(name="AVAILABILITY")
	private boolean availability;
	
	@Column(name="APPROVAL")
	private boolean approval;
	
	@Column(name="IMAGE1")
	private String image1;
	
	@Column(name="IMAGE2")
	private String image2;

	@Column(name="IMAGE3")
	private String image3;
	
	@Column(name="IMAGE4")
	private String image4;
	
	@Column(name="IMAGE5")
	private String image5;

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public String getImage5() {
		return image5;
	}

	public void setImage5(String image5) {
		this.image5 = image5;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public long getProviderId() {
		return providerId;
	}

	public void setProviderId(long providerId) {
		this.providerId = providerId;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getHouseCity() {
		return houseCity;
	}

	public void setHouseCity(String houseCity) {
		this.houseCity = houseCity;
	}

	public String getHouseState() {
		return houseState;
	}

	public void setHouseState(String houseState) {
		this.houseState = houseState;
	}

	public String getHouseArea() {
		return houseArea;
	}

	public void setHouseArea(String houseArea) {
		this.houseArea = houseArea;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getHouseProof() {
		return houseProof;
	}

	public void setHouseProof(String houseProof) {
		this.houseProof = houseProof;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}
}
