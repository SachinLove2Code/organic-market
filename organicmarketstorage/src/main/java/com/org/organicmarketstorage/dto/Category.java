package com.org.organicmarketstorage.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Sachin
 *
 */

@Entity
public class Category implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	private fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String discription;
	private String imageURL;
	
	@Column(name = "is_active")
	private boolean active = true;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", discription=" + discription + ", imageURL=" + imageURL
				+ ", active=" + active + "]";
	}
	
	

}
