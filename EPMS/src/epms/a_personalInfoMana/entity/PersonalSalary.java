package epms.a_personalInfoMana.entity;

public class PersonalSalary {
	int pid;
	int month;
	int  year;
	int basicSalary;
	int otSalary;
	int allowance;
	int total;
	public PersonalSalary(){
		
	}
	public PersonalSalary(int pid,int year, int month, int basicSalary, int otSalary,
			int allowance, int total) {
		super();
		this.pid = pid;
		this.year=year;
		this.month = month;
		this.basicSalary = basicSalary;
		this.otSalary = otSalary;
		this.allowance = allowance;
		this.total = total;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}
	public int getOtSalary() {
		return otSalary;
	}
	public void setOtSalary(int otSalary) {
		this.otSalary = otSalary;
	}
	public int getAllowance() {
		return allowance;
	}
	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "PersonalSalary [pid=" + pid + ", month=" + month + ", year="
				+ year + ", basicSalary=" + basicSalary + ", otSalary="
				+ otSalary + ", allowance=" + allowance + ", total=" + total
				+ "]";
	}
	
	
}
