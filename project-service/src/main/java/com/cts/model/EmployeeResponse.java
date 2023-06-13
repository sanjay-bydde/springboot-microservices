package com.cts.model;

public class EmployeeResponse {

	private Long eid;
	private String firstName;
	private String lastName;
	private String emailId;
	private Long pid;
	private String projectName;
	private String description;
	
	public EmployeeResponse(){
		
	}
	public EmployeeResponse(Long eid, String firstName, String lastName, String emailId, Long pid, String projectName,
			String description) {
		super();
		this.eid = eid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.pid = pid;
		this.projectName = projectName;
		this.description = description;
	}
	public Long getEid() {
		return eid;
	}
	public void setEid(Long eid) {
		this.eid = eid;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
