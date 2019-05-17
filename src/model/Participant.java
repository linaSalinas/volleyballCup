package model;

import javafx.scene.image.Image;

public class Participant {
	
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private Gender gender;
	private String country;
	private String imageurl;
	private String birthday;
	
	public Participant(String id, String firstName, String lastName, String email, Gender gender, String country,
			String imageurl, String birthday) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.imageurl = imageurl;
		this.birthday = birthday;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public Gender getGender() {
		return gender;
	}

	public String getCountry() {
		return country;
	}

	public String getImageUrl() {
		return imageurl;
	}

	public String getBirthday() {
		return birthday;
	}
}
