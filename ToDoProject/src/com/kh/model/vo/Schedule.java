package com.kh.model.vo;


public class Schedule {
	
	private int scheduleId;
	private int schedulNo;
	private String title;
	private String detail;
	private String deadline;
	private String clear;
	
	public Schedule() {
		super();
	}

	
	
	public Schedule(int schedulNo, String title, String detail, String deadline, String clear) {
		super();
		this.schedulNo = schedulNo;
		this.title = title;
		this.detail = detail;
		this.deadline = deadline;
		this.clear = clear;
	}


	public Schedule(int scheduleId, int schedulNo, String title, String detail, String deadline, String clear) {
		super();
		this.scheduleId = scheduleId;
		this.schedulNo = schedulNo;
		this.title = title;
		this.detail = detail;
		this.deadline = deadline;
		this.clear = clear;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public int getSchedulNo() {
		return schedulNo;
	}

	public void setSchedulNo(int schedulNo) {
		this.schedulNo = schedulNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getClear() {
		return clear;
	}

	public void setClear(String clear) {
		this.clear = clear;
	}

	@Override
	public String toString() {
		return scheduleId + ", " + schedulNo + ", " + title + ", "
				+ detail + ", " + deadline + ", " + clear;
	}
	
	
	
}
