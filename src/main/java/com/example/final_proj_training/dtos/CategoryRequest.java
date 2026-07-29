package com.example.final_proj_training.dtos;

public class CategoryRequest {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CategoryRequest [name=" + name + "]";
	}

	public CategoryRequest(String name) {
		super();
		this.name = name;
	}

	public CategoryRequest() {
		super();
	}
	
	
}
