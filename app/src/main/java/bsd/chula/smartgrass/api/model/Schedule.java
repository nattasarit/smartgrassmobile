package bsd.chula.smartgrass.api.model;

import com.google.gson.annotations.SerializedName;

public class Schedule {

	@SerializedName("ScheduleCategoryName")
	private String scheduleCategoryName;

	@SerializedName("ScheduleCategoryID")
	private String scheduleCategoryID;

	@SerializedName("Time")
	private String time;

	@SerializedName("WorkID")
	private String workID;

	@SerializedName("ScheduleID")
	private String scheduleID;

	@SerializedName("Detail")
	private String detail;

	@SerializedName("Date")
	private String date;

	public void setScheduleCategoryName(String scheduleCategoryName){
		this.scheduleCategoryName = scheduleCategoryName;
	}

	public String getScheduleCategoryName(){
		return scheduleCategoryName;
	}

	public void setScheduleCategoryID(String scheduleCategoryID){
		this.scheduleCategoryID = scheduleCategoryID;
	}

	public String getScheduleCategoryID(){
		return scheduleCategoryID;
	}

	public void setTime(String time){
		this.time = time;
	}

	public String getTime(){
		return time;
	}

	public void setWorkID(String workID){
		this.workID = workID;
	}

	public String getWorkID(){
		return workID;
	}

	public void setScheduleID(String scheduleID){
		this.scheduleID = scheduleID;
	}

	public String getScheduleID(){
		return scheduleID;
	}

	public void setDetail(String detail){
		this.detail = detail;
	}

	public String getDetail(){
		return detail;
	}

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}
}