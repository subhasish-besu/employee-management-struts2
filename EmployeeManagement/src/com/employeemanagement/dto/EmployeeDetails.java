package com.employeemanagement.dto;


public class EmployeeDetails implements Comparable<EmployeeDetails> {
	private String tableId;
	private String empId;
	private String password;
	private String fname;
	private String lname;
	private String email;
	private String salary;
	private String gender;
	private String mngEmpId;	
	private String status;
	private String updateByEmpId;
	private String updateTime;
	private String roleId;
	private String roleName;
	private boolean loginStatus;
	
	//private static EmployeeDetailsSingletone singleInstance = null;
	/*
	 private EmployeeDetailsSingletone()
	    {
	        
	    }*/
	
	/*public static EmployeeDetailsSingletone getInstance()
    {
        if (singleInstance == null)
            singleInstance = new EmployeeDetailsSingletone();
 
        return singleInstance;
    }*/
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMngEmpId() {
		return mngEmpId;
	}
	public void setMngEmpId(String mngEmpId) {
		this.mngEmpId = mngEmpId;
	}
	public boolean isLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTableId() {
		return tableId;
	}
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
	public String getUpdateByEmpId() {
		return updateByEmpId;
	}
	public void setUpdateByEmpId(String updateByEmpId) {
		this.updateByEmpId = updateByEmpId;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	 public int compareTo(EmployeeDetails other) {
	        return salary.compareTo(other.salary);
	    }

}
