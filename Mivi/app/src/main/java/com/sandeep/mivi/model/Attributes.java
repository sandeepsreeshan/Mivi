package com.sandeep.mivi.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Attributes implements Serializable {

	@SerializedName("payment-type")
	private String paymentType;

	@SerializedName("next-billing-date")
	private Object nextBillingDate;

	@SerializedName("email-subscription-status")
	private boolean emailSubscriptionStatus;

	@SerializedName("email-address")
	private String emailAddress;

	@SerializedName("date-of-birth")
	private String dateOfBirth;

	@SerializedName("contact-number")
	private String contactNumber;

	@SerializedName("unbilled-charges")
	private Object unbilledCharges;

	@SerializedName("title")
	private String title;

	@SerializedName("first-name")
	private String firstName;

	@SerializedName("last-name")
	private String lastName;

	@SerializedName("email-address-verified")
	private boolean emailAddressVerified;

	public void setPaymentType(String paymentType){
		this.paymentType = paymentType;
	}

	public String getPaymentType(){
		return paymentType;
	}

	public void setNextBillingDate(Object nextBillingDate){
		this.nextBillingDate = nextBillingDate;
	}

	public Object getNextBillingDate(){
		return nextBillingDate;
	}

	public void setEmailSubscriptionStatus(boolean emailSubscriptionStatus){
		this.emailSubscriptionStatus = emailSubscriptionStatus;
	}

	public boolean isEmailSubscriptionStatus(){
		return emailSubscriptionStatus;
	}

	public void setEmailAddress(String emailAddress){
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress(){
		return emailAddress;
	}

	public void setDateOfBirth(String dateOfBirth){
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfBirth(){
		return dateOfBirth;
	}

	public void setContactNumber(String contactNumber){
		this.contactNumber = contactNumber;
	}

	public String getContactNumber(){
		return contactNumber;
	}

	public void setUnbilledCharges(Object unbilledCharges){
		this.unbilledCharges = unbilledCharges;
	}

	public Object getUnbilledCharges(){
		return unbilledCharges;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setEmailAddressVerified(boolean emailAddressVerified){
		this.emailAddressVerified = emailAddressVerified;
	}

	public boolean isEmailAddressVerified(){
		return emailAddressVerified;
	}
}