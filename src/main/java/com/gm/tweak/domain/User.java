package com.gm.tweak.domain;

public class User {

	private Long id;
	private String email;
	private String username;
	private String password;

	// TODO CR-NANO: Tendria que tener el id por parametro, de lo contrario se
	// puede cambiar el identificador al objeto y se violaria la integridad del
	// objeto.
	public User(String email, String username, String password) {
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

	// TODO CR-NANO: Falta definir equals, es decir, el mecanismo por el cual un
	// usuario es distinto a otro.
}