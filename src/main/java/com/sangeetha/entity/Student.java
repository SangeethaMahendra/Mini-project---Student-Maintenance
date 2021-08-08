package com.sangeetha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student {
	@Id
	@GeneratedValue
	@Column (name = "Student_id")
	private int id;
	@Column (name = "Student_firstName")
	private String firstName;
	@Column (name = "Student_lastName")
	private String lastName;
	@Column (name = "Student_grade")
	private int grade;
	@Column (name = "parent_emailAddress" , length = 200)
	private String email;


	public Student() {}

	public Student(int id, String firstName, String lastName, int grade, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", grade=" + grade
				+ ", email=" + email + "]";
	}


}
