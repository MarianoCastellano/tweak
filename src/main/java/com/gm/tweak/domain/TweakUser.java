package com.gm.tweak.domain;

public class TweakUser {

	private Long id;
	private String email;
	private String username;

	public TweakUser(String email, String username) {
		this.email = email;
		this.username = username;
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
}
