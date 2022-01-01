package com.sdp3.project.business.domain;

import java.util.List;

import com.sdp3.project.models.House;

public class UserHouseData {
	private List<House> houses;
	private List<Boolean> isRequested;
	private List<Boolean> isPending;
	private List<Boolean> isCompleted;
	private boolean currentStay;
	public List<House> getHouses() {
		return houses;
	}
	public void setHouses(List<House> houses) {
		this.houses = houses;
	}
	public List<Boolean> getIsRequested() {
		return isRequested;
	}
	public void setIsRequested(List<Boolean> isRequested) {
		this.isRequested = isRequested;
	}
	public List<Boolean> getIsCompleted() {
		return isCompleted;
	}
	public void setIsCompleted(List<Boolean> isCompleted) {
		this.isCompleted = isCompleted;
	}
	public List<Boolean> getIsPending() {
		return isPending;
	}
	public void setIsPending(List<Boolean> isPending) {
		this.isPending = isPending;
	}
	public boolean isCurrentStay() {
		return currentStay;
	}
	public void setCurrentStay(boolean currentStay) {
		this.currentStay = currentStay;
	}
}
