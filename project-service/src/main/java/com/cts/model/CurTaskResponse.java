package com.cts.model;

public class CurTaskResponse {

	private Long pId;
	private String pName;
	private String description;
	private Long tId;
	private String curTask;
	private String status;
	public CurTaskResponse() {
		
	}
	public CurTaskResponse(Long pId, String pName, String description, Long tId, String curTask, String status) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.description = description;
		this.tId = tId;
		this.curTask = curTask;
		this.status = status;
	}
	public Long getpId() {
		return pId;
	}
	public void setpId(Long pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
	}
	public String getCurTask() {
		return curTask;
	}
	public void setCurTask(String curTask) {
		this.curTask = curTask;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
