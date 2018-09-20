package com.sandeep.mivi.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Services implements Serializable {

	@SerializedName("links")
	private Links links;

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}
}