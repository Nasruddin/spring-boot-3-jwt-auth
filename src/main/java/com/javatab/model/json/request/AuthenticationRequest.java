package com.javatab.model.json.request;

import com.javatab.model.base.ModelBase;

public class AuthenticationRequest extends ModelBase {

	private static final long serialVersionUID = 6624726180748515507L;
	private String username;
	private String password;
	private String device;

	public AuthenticationRequest() {
		super();
	}

	public AuthenticationRequest(String username, String password, String device) {
		this.setUsername(username);
		this.setPassword(password);
		this.setDevice(device);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}
}
