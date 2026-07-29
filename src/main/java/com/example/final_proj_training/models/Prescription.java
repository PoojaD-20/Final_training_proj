package com.example.final_proj_training.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Prescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int user_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Prescription() {
		super();
	}
	public Prescription(int id, int user_id) {
		super();
		this.id = id;
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Prescription [id=" + id + ", user_id=" + user_id + "]";
	}
	
	

}
