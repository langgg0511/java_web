package epms.b_empInfoMana.entity;
/**
 * 该类在删除、修改、增加员工信息时使用
 */
public class EmployeeInfo {
	private int eid;
	private String name;
	private int age;
	private String sex;
	private int deptId;
	private int jobId;
	private int time;
	public EmployeeInfo(){
		
	}
	
	public EmployeeInfo(int eid, String name, int age, String sex, int deptId,
			int jobId, int time) {
		super();
		this.eid = eid;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.deptId = deptId;
		this.jobId = jobId;
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
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
}
