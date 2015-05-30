package com.gm.tweak.domain;

public class TweakUser {

	private Long id;
	private String email;
	private String username;
	private String password;

	public TweakUser(String email, String username, String password) {
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public void assignId(long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
