package com.EPMS.reportMana.po;

//Attendance�İ�װ��
public class AttendanceVo {
	private String name;
	private Attendance attendance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Attendance getAttendance() {
		return attendance;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}

	@Override
	public String toString() {
		return "AttendanceVo [name=" + name + ", attendance=" + attendance + "]";
	}
	
	
}
