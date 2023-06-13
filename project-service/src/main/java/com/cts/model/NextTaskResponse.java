package com.cts.model;

public class NextTaskResponse {

	private Long pId;
	private String pName;
	private String description;
	private Long tId;
	private String nextTask;
	public NextTaskResponse() {
		
	}
	
	public NextTaskResponse(Long pId, String pName, String description, Long tId, String nextTask) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.description = description;
		this.tId = tId;
		this.nextTask = nextTask;
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
	public String getNextTask() {
		return nextTask;
	}
	public void setNextTask(String nextTask) {
		this.nextTask = nextTask;
	}
	
	
}
