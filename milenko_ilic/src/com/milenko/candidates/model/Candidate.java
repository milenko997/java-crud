package com.milenko.candidates.model;

public class Candidate {

	private int id;
	private String full_name;
	private String date_of_birth;
	private String contact_number;
	private String email;

	public Candidate() {
		
	}
	
	public Candidate(int id, String full_name, String date_of_birth, String contact_number, String email) {
		this(full_name, date_of_birth, contact_number, email);
		this.id = id;
	}

	public Candidate(String full_name, String date_of_birth, String contact_number, String email) {
		this.full_name = full_name;
		this.date_of_birth = date_of_birth;
		this.contact_number = contact_number;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Candidate [id: " + id + ", name: " + full_name + ", date of birth: " + date_of_birth + ", contact number: "
				+ contact_number + ", email: " + email + "]";
	}

}
