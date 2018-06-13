package a_personalInfoMana.entity;

public class Job {
	private int id;
	private String jname;
	public Job(){
		
	}
	public Job(int id, String jname) {
		super();
		this.id = id;
		this.jname = jname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", jname=" + jname + "]";
	}
	
}
