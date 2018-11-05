package com.cg.frs.dto;

public class FlatRegistrationDTO {
	private int ownerIds;
	private int flatId;
	private String flatType;
	private int flatArea;
	private int rent;
	private int deposite;
	
	//Setters and Getters
	
	public int getOwnerIds() {
		return ownerIds;
	}
	public void setOwnerIds(int ownerIds) {
		this.ownerIds = ownerIds;
	}
	public int getFlatId() {
		return flatId;
	}
	public void setFlatId(int flatId) {
		this.flatId = flatId;
	}
	public String getFlatType() {
		return flatType;
	}
	public void setFlatType(String flatType) {
		this.flatType = flatType;
	}
	public int getFlatArea() {
		return flatArea;
	}
	public void setFlatArea(int flatArea) {
		this.flatArea = flatArea;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	public int getDeposite() {
		return deposite;
	}
	public void setDeposite(int deposite) {
		this.deposite = deposite;
	}
	@Override
	public String toString() {
		return "FlatRegistrationDTO [ownerIds=" + ownerIds + ", flatId="
				+ flatId + ", flatType=" + flatType + ", flatArea=" + flatArea
				+ ", rent=" + rent + ", deposite=" + deposite + "]";
	}
	
	
	
}
