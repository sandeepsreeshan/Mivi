package com.sandeep.mivi.model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;


public class CollectionResponse implements Serializable {

	@SerializedName("data")
	private Data data;

	@SerializedName("included")
	private List<IncludedItem> included;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setIncluded(List<IncludedItem> included){
		this.included = included;
	}

	public List<IncludedItem> getIncluded(){
		return included;
	}
}