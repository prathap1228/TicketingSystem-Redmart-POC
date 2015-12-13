package com.redmart.DTO;

import java.io.Serializable;

public class LoginResultDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer statusCode;

	private String message;

	private LoginDataDTO data;

	public static class LoginDataDTO {
		
		private Integer employeeId;

		private String welcomeMessage;

		public Integer getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(Integer employeeId) {
			this.employeeId = employeeId;
		}

		public String getWelcomeMessage() {
			return welcomeMessage;
		}

		public void setWelcomeMessage(String welcomeMessage) {
			this.welcomeMessage = welcomeMessage;
		}
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LoginDataDTO getData() {
		return data;
	}

	public void setData(LoginDataDTO data) {
		this.data = data;
	}
}
