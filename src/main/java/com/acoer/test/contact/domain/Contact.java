package com.acoer.test.contact.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "contacts")
public class Contact {

	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private long id;

	@Id
	@ApiModelProperty(notes = "The contacts first name")
	@NonNull()
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

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
