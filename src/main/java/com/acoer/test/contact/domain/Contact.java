package com.acoer.test.contact.domain;

//imports
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import io.swagger.annotations.ApiModelProperty;

//Contact Class
@Document(collection = "contacts")
public class Contact {

	//Transient Contacts Sequence
	@Transient
    public static final String SEQUENCE_NAME = "contacts_sequence";
	
	//ID 
	@Id
	private long id;

	//First Name
	@Id
	@ApiModelProperty(notes = "The contacts first name")
	@NonNull()
	private String fName;
	
	//Surname
	@ApiModelProperty(notes = "The contacts surname")
	private String sName;
	
	//phoneNum
	@ApiModelProperty(notes = "The contacts Phone Number")
	private int phoneNum;

	public Contact(){
	}

	//Constructor
	public Contact(String fName, String sName, int phoneNum){
		this.fName = fName;
		this.sName = sName;
		this.phoneNum = phoneNum;
	}

	//get method ID
	public long getId() {
		return id;
	}
	//set method ID
	public void setId(long id) {
		this.id = id;
	}
	
	//get method First Name
	public String getFName(){
		return fName;
	}
	//set method First Name
	public void setFName(String fName){
		this.fName = fName;
	}
	//get method Surname
	public String getSName(){
		return sName;
	}
	//set method Surname 
	public void setSName(String sName){
		this.sName = sName;
	}
	//get method number
	public int getNum(){
		return phoneNum;
	}
	//set method number
	public void setNum(int phoneNum){
		this.phoneNum = phoneNum;
	}
}
