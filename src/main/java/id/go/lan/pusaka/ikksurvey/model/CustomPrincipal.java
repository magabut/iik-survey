package id.go.lan.pusaka.ikksurvey.model;

import java.io.Serializable;

public class CustomPrincipal implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String email;
	private String kementrianLembaga;

	public CustomPrincipal() {

	}

	public CustomPrincipal(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}

	public CustomPrincipal(String username, String email, String kementrianLembaga) {
		super();
		this.username = username;
		this.email = email;
		this.kementrianLembaga = kementrianLembaga;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKementrianLembaga() {
		return kementrianLembaga;
	}

	public void setKementrianLembaga(String kementrianLembaga) {
		this.kementrianLembaga = kementrianLembaga;
	}

}