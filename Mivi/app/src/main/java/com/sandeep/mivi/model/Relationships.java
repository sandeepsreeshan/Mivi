package com.sandeep.mivi.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Relationships implements Serializable {

	@SerializedName("subscriptions")
	private Subscriptions subscriptions;

	public void setSubscriptions(Subscriptions subscriptions){
		this.subscriptions = subscriptions;
	}

	public Subscriptions getSubscriptions(){
		return subscriptions;
	}
}