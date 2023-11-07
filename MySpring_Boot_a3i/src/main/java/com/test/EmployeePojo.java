package com.test;

public class EmployeePojo {
	private int eid;
	private String ename;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEsalary() {
		return esalary;
	}
	public void setEsalary(int esalary) {
		this.esalary = esalary;
	}
	private int esalary;
	@Override
	public String toString() {
		return "EmployeePojo [eid=" + eid + ", ename=" + ename + ", esalary=" + esalary + "]";
	}
	public EmployeePojo() {
		super();
	}
	
}
