package com.example.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Player")
public class Department {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int AthleteId;
	@NotBlank(message = "AthleteName Name is mandatory")
	private String AthleteName;
	@NotBlank(message = "ContactPerson Name is mandatory")
	private String ContactPerson;
	@Email
	private String EMail;
	@Min(13)
	@Max(16)
	private int Age;
	@Digits(fraction = 0, integer = 3)
	private int Height;
	@Size(min = 1, max = 5)
	private String BasketballSkill;
	
	public int getAthleteId() {
		return AthleteId;
	}
	public void setAthleteId(int athleteId) {
		AthleteId = athleteId;
	}
	public String getAthleteName() {
		return AthleteName;
	}
	public void setAthleteName(String athleteName) {
		AthleteName = athleteName;
	}
	public String getContactPerson() {
		return ContactPerson;
	}
	public void setContactPerson(String contactPerson) {
		ContactPerson = contactPerson;
	}
	
	public String getEMail() {
		return EMail;
	}
	public void setEMail(String eMail) {
		EMail = eMail;
	}
	public String getBasketballSkill() {
		return BasketballSkill;
	}
	public void setBasketballSkill(String basketballSkill) {
		BasketballSkill = basketballSkill;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public int getHeight() {
		return Height;
	}
	public void setHeight(int height) {
		Height = height;
	}

}
