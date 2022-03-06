package com.acoer.test.contact.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "contacts")
public class Contact {

	@Id
	@ApiModelProperty(notes = "The contacts first name")
	private String fName;
	
	@ApiModelProperty(notes = "The contacts surname")
	private String sName;
	
	@ApiModelProperty(notes = "The contacts Phone Number")
	private int phoneNum;

	public Contact(){
	}

	public Contact(String fName, String sName, int phoneNum){
		this.fName = fName;
		this.sName = sName;
		this.phoneNum = phoneNum;
	}

	
	public String getFName(){
		return fName;
	}
	public void setFName(String fName){
		this.fName = fName;
	}

	public String getSName(){
		return sName;
	}
	public void setSName(String sName){
		this.sName = sName;
	}
	
	public int getNum(){
		return phoneNum;
	}
	public void setNum(int phoneNum){
		this.phoneNum = phoneNum;
	}
}
