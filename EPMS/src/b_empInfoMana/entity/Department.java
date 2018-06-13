package b_empInfoMana.entity;

public class Department {
	private int id;//部门id
	private String dname;//部门名称
	
	public Department() {
		
	}
	public Department(int id, String dname) {
		this.id = id;
		this.dname = dname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", dname=" + dname + "]";
	}

	
	
}
