package com.employeemanagement.business;

public class EmpAuditBusiness {
 private String empId;

public String getEmpId() {
	return empId;
}

public void setEmpId(String empId) {
	this.empId = empId;
}
 

	public String checkId() {
		return "true";
	}
}
