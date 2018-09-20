package com.sandeep.mivi.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Links implements Serializable {

	@SerializedName("self")
	private String self;

	public void setSelf(String self){
		this.self = self;
	}

	public String getSelf(){
		return self;
	}
}