package com.example.final_proj_training.exceptions;

import java.time.LocalDateTime;

public class ErrorResponse {

	
	LocalDateTime timeStamp;
	int status;
	String message;
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ErrorResponse(LocalDateTime timeStamp, int status, String message) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.message = message;
	}
	@Override
	public String toString() {
		return "ErrorResponse [timeStamp=" + timeStamp + ", status=" + status + ", message=" + message + "]";
	}
    
    
}
