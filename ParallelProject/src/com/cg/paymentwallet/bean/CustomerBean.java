package com.cg.paymentwallet.bean;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bank_Customers")
public class CustomerBean {
	
	@Id
	@Column(name="cust_id")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerId;

	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public CustomerBean(int customerId, String firstName, String lastName,
			String emailId, String phoneNo, String panNum, String address) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.panNum = panNum;
		this.address = address;
	}
	@Column(name="First_name")
	private String firstName;
	
	@Column(name="Last_name")
	private String lastName;
	
	@Column(name="email_id")
	private String emailId;
	
	
	
	@Column(name="phone_number")
	private String phoneNo;
	
	@Column(name="pan_number")
	private String panNum;
	
	@Column(name="address")
	private String address;
	
	

	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getPanNum() {
		return panNum;
	}
	public void setPanNum(String panNum) {
		this.panNum = panNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "CustomerBean [customerId=" + customerId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", phoneNo=" + phoneNo + ", panNum=" + panNum + ", address="
				+ address + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerBean other = (CustomerBean) obj;
		if (customerId != other.customerId)
			return false;
		return true;
	}
	public CustomerBean() {
		super();
	}
	
	
	
		
}
