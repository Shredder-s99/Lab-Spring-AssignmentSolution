package com.greatLearning.Student_Management.Model;

import javax.persistence.Entity;
import javax.persistence.Table;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "students")

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Student_Id")
	private int id;
	@Column(name = "Dept")
	private String dept;
	@Column(name = "Country")
	private String country;
	@Column(name = "Student_Name")
	private String fullName;

	public int getId() {
		return id;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Student() {
	}

	public Student(String fullName, String dept, String country) {
		super();
		this.fullName = fullName;
		this.dept = dept;
		this.country = country;
	}

}
