package com.kh.model.vo;

import java.sql.Date;

public class Schedule {
	
	private int scheduleId;
	private int scheduleNo;
	private String title;
	private String detail;
	private Date deadline;
	private String clear;
	
	public Schedule() {
		super();
	}

	
	
	public Schedule(int scheduleNo, String title, String detail, Date deadline, String clear) {
		this.scheduleNo = scheduleNo;
		this.title = title;
		this.detail = detail;
		this.deadline = deadline;
		this.clear = clear;
	}


	public Schedule(int scheduleId, int scheduleNo, String title, String detail, Date deadline, String clear) {
		super();
		this.scheduleId = scheduleId;
		this.scheduleNo = scheduleNo;
		this.title = title;
		this.detail = detail;
		this.deadline = deadline;
		this.clear = clear;
	}

	public Schedule(String title, String detail, Date deadline) {
		this.title = title;
		this.detail = detail;
		this.deadline = deadline;
	}



	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public int getScheduleNo() {
		return scheduleNo;
	}

	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
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

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
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
		return scheduleNo + ", " + title + ", "
				+ detail + ", " + deadline + ", " + clear;
	}
	
	
	
}
