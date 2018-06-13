package epms.a_personalInfoMana.entity;

public class Attendance {
	private int eid;
	private int year;
	private int month;
	private int prin_day;//应到天数
	private int absenteeism;//缺勤天数
	private int _leave;//请假天数
	private int onduty_day;//实到天数
	private int overtime;//加班天数
	public Attendance(){
		
	}
	public Attendance(int eid, int year, int month, int prin_day,
			int absenteeism, int _leave, int onduty_day, int overtime) {
		super();
		this.eid = eid;
		this.year = year;
		this.month = month;
		this.prin_day = prin_day;
		this.absenteeism = absenteeism;
		this._leave = _leave;
		this.onduty_day = onduty_day;
		this.overtime = overtime;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getPrin_day() {
		return prin_day;
	}
	public void setPrin_day(int prin_day) {
		this.prin_day = prin_day;
	}
	public int getAbsenteeism() {
		return absenteeism;
	}
	public void setAbsenteeism(int absenteeism) {
		this.absenteeism = absenteeism;
	}
	public int get_Leave() {
		return _leave;
	}
	public void set_Leave(int _leave) {
		this._leave = _leave;
	}
	public int getOnduty_day() {
		return onduty_day;
	}
	public void setOnduty_day(int onduty_day) {
		this.onduty_day = onduty_day;
	}
	public int getOvertime() {
		return overtime;
	}
	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}
	@Override
	public String toString() {
		return "Attendance [eid=" + eid + ", year=" + year + ", month=" + month
				+ ", prin_day=" + prin_day + ", absenteeism=" + absenteeism
				+ ", leave=" + _leave + ", onduty_day=" + onduty_day
				+ ", overtime=" + overtime + "]";
	}
	
}
