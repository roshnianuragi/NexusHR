package com.nexus.hr.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private String phone;

	private int age;

	// GENDER
	private String gender;

	private String aadhaarNo;

	private String panNo;

	private double salary;

	private String designation;

	// AUDIT FIELDS
	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	@com.fasterxml.jackson.annotation.JsonIgnoreProperties("employees")
	private Department department;

	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private EmployeeProfile profile;

	@ManyToMany
	@JoinTable(name = "employee_project",

			joinColumns = @JoinColumn(name = "employee_id"),

			inverseJoinColumns = @JoinColumn(name = "project_id"))
	private List<Project> projects;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<LeaveRequest> leaveRequests;

	// AUTO TIMESTAMP

	@PrePersist
	public void onCreate() {

		this.createdAt = LocalDateTime.now();

		this.updatedAt = LocalDateTime.now();
	}

	@PreUpdate
	public void onUpdate() {

		this.updatedAt = LocalDateTime.now();
	}

	// GETTERS & SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {

		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {

		this.age = age;
	}

	// GENDER

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {

		this.gender = gender;
	}

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {

		this.aadhaarNo = aadhaarNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {

		this.panNo = panNo;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {

		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {

		this.designation = designation;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {

		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {

		this.updatedAt = updatedAt;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {

		this.department = department;
	}

	public EmployeeProfile getProfile() {
		return profile;
	}

	public void setProfile(EmployeeProfile profile) {

		this.profile = profile;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {

		this.projects = projects;
	}

	public List<LeaveRequest> getLeaveRequests() {
		return leaveRequests;
	}

	public void setLeaveRequests(List<LeaveRequest> leaveRequests) {

		this.leaveRequests = leaveRequests;
	}

	// SAFE TOSTRING

	@Override
	public String toString() {

		return "Employee{"

				+ "id=" + id

				+ ", firstName='" + firstName + '\''

				+ ", lastName='" + lastName + '\''

				+ ", email='" + email + '\''

				+ ", phone='" + phone + '\''

				+ ", gender='" + gender + '\''

				+ ", age=" + age

				+ ", salary=" + salary

				+ ", designation='" + designation + '\''

				+ ", createdAt=" + createdAt

				+ ", updatedAt=" + updatedAt

				+ '}';
	}
}