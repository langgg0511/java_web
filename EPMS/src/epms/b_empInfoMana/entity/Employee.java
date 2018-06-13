package epms.b_empInfoMana.entity;
/**
 * 该类在查询员工信息时使用
 */
public class Employee {
	private int eid;//员工号
	private String name;
	private int age;
	private String sex;
	private String dname;//所属部门名称
	private String jname;//职位
	private int time;
	public Employee(){
		
	}
	public Employee(int eid, String name, int age, String sex, String dname,
			String jname, int time) {
		super();
		this.eid = eid;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.dname = dname;
		this.jname = jname;
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
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", age=" + age
				+ ", sex=" + sex + ", dname=" + dname + ", jname=" + jname
				+ ", time=" + time + "]";
	}
	
}
