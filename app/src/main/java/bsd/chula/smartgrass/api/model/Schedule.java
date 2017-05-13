package bsd.chula.smartgrass.api.model;

import com.google.gson.annotations.SerializedName;

public class Schedule {

	@SerializedName("ScheduleCategoryName")
	private String scheduleCategoryName;

	@SerializedName("ScheduleCategoryID")
	private String scheduleCategoryID;

	@SerializedName("Date")
	private String date;

	@SerializedName("StartTime")
	private String startTime;

	@SerializedName("EndTime")
	private String endTime;

	@SerializedName("WorkID")
	private String workID;

	@SerializedName("ScheduleID")
	private String scheduleID;

	@SerializedName("Detail")
	private String detail;

	public String getScheduleCategoryName() {
		return scheduleCategoryName;
	}

	public void setScheduleCategoryName(String scheduleCategoryName) {
		this.scheduleCategoryName = scheduleCategoryName;
	}

	public String getScheduleCategoryID() {
		return scheduleCategoryID;
	}

	public void setScheduleCategoryID(String scheduleCategoryID) {
		this.scheduleCategoryID = scheduleCategoryID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getWorkID() {
		return workID;
	}

	public void setWorkID(String workID) {
		this.workID = workID;
	}

	public String getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(String scheduleID) {
		this.scheduleID = scheduleID;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}