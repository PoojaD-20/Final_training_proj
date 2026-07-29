package com.example.final_proj_training.dtos;

public class ValidTokenResponseDto {

	private boolean valid;
	private int id;
	private String name;
	public ValidTokenResponseDto() {
		super();
	}
	public ValidTokenResponseDto(boolean valid, int id, String name) {
		super();
		this.valid = valid;
		this.id = id;
		this.name = name;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
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
	@Override
	public String toString() {
		return "ValidTokenResponseDto [valid=" + valid + ", id=" + id + ", name=" + name + "]";
	}
}
