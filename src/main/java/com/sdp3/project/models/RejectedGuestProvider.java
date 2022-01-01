package com.sdp3.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REJECTED_PROVIDER")
public class RejectedGuestProvider {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="GUEST_PROVIDER_ID")
	private long guestProviderId;

	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="PHONE_NO")
	private String phoneNo;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="GOVERNMENT_ID")
	private String governmentId;
	
	@Column(name="GOVERNMENT_ID_PROOF")
	private String governmentIdProof;
	
	@Column(name="ROLE")
	private String role;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="ADDRESS_PROOF")
	private String addressProof;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGovernmentId() {
		return governmentId;
	}

	public void setGovernmentId(String governmentId) {
		this.governmentId = governmentId;
	}

	public String getGovernmentIdProof() {
		return governmentIdProof;
	}

	public void setGovernmentIdProof(String governmentIdProof) {
		this.governmentIdProof = governmentIdProof;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressProof() {
		return addressProof;
	}

	public void setAddressProof(String addressProof) {
		this.addressProof = addressProof;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public long getGuestProviderId() {
		return guestProviderId;
	}

	public void setGuestProviderId(long guestProviderId) {
		this.guestProviderId = guestProviderId;
	}
}
