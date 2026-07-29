package com.example.final_proj_training.dtos;

public class CategoryResponse {

	private int id;
	private String name;
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
	public CategoryResponse(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "CategoryResponse [id=" + id + ", name=" + name + "]";
	}
	public CategoryResponse() {
		super();
	}
	
	
}
