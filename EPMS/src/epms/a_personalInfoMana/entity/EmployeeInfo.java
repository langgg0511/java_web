package epms.a_personalInfoMana.entity;

public class EmployeeInfo {
	private int eid;
	private String name;
	private int age;
	private String sex;
	private int department;
	private int job;
	private int time;
	public EmployeeInfo(){
		
	}
	public EmployeeInfo(int eid, String name, int age, String sex,
			int department, int job, int time) {
		super();
		this.eid = eid;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.department = department;
		this.job = job;
		this.time = time;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	public int getJob() {
		return job;
	}
	public void setJob(int job) {
		this.job = job;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "EmployeeInfo [eid=" + eid + ", name=" + name + ", age=" + age
				+ ", sex=" + sex + ", department=" + department + ", job="
				+ job + ", time=" + time + "]";
	}
	
	
}
