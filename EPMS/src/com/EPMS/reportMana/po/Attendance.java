package com.EPMS.reportMana.po;

public class Attendance {
	private int id;
	private int eid;
	private int year;
	private int month;
	private int absenteeism;
	private int leave;
	private int prin_day;
	private int overtime;
	private int onduty_day;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getAbsenteeism() {
		return absenteeism;
	}
	public void setAbsenteeism(int absenteeism) {
		this.absenteeism = absenteeism;
	}
	public int getLeave() {
		return leave;
	}
	public void setLeave(int leave) {
		this.leave = leave;
	}
	public int getPrin_day() {
		return prin_day;
	}
	public void setPrin_day(int prin_day) {
		this.prin_day = prin_day;
	}
	public int getOvertime() {
		return overtime;
	}
	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}
	public int getOnduty_day() {
		return onduty_day;
	}
	public void setOnduty_day(int onduty_day) {
		this.onduty_day = onduty_day;
	}
	@Override
	public String toString() {
		return "Attendance [id=" + id + ", eid=" + eid + ", month=" + month + ", absenteeism=" + absenteeism
				+ ", leave=" + leave + ", prin_day=" + prin_day + ", overtime=" + overtime + ", onduty_day="
				+ onduty_day + "]";
	}
	
	
}
