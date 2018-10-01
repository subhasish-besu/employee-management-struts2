package com.employeemanagement.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.employeemanagement.business.EmployeeBusiness;
import com.employeemanagement.dto.EmployeeDetails;


public  class NewEmpAction implements SessionAware{
	private String newEmpId;
	
	public String getNewEmpId() {
		return newEmpId;
	}

	public void setNewEmpId(String newEmpId) {
		this.newEmpId = newEmpId;
	}

	private String newEmpFname;
	public String getNewEmpFname() {
		return newEmpFname;
	}

	public void setNewEmpFname(String newEmpFname) {
		this.newEmpFname = newEmpFname;
	}

	private String newEmpLname;
	private String newEmpMail;
	private String newEmpSalary;
	private String newEmpGender;
	private String newMngEmpId;
	private String newEmpStatus;
	
	EmployeeDetails newEp = new EmployeeDetails();	
	private Map<String, Object> session;	
	private String errorMsg;
	
	
	
	public EmployeeDetails getNewEp() {
		return newEp;
	}

	public void setNewEp(EmployeeDetails newEp) {
		this.newEp = newEp;
	}
	
	// add logger here---
		static final Logger LOGGER = Logger.getLogger(NewEmpAction.class);

	public String execute() {	
		
		EmployeeBusiness data = new EmployeeBusiness();
		
		try {
			
				LOGGER.info("In execute of NewEmpAction -> " + newEmpId);
				
				newEp.setEmpId(newEmpId);
				newEp.setFname(newEmpFname);
				newEp.setLname(newEmpLname);
				newEp.setEmail(newEmpMail);
				newEp.setSalary(newEmpSalary);
				newEp.setGender(newEmpGender);
				newEp.setMngEmpId(newMngEmpId);
				newEp.setStatus(newEmpStatus);
				
				
				
				newEp = data.getNewEmployee(newEp);
				
			 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			LOGGER.error(e.getMessage(), e);
			return "error";
		}
		
		LOGGER.info("Exit on NewEmpAction ->");
		
		
		return "success";
	}// execute end here --

	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getNewEmpLname() {
		return newEmpLname;
	}

	public void setNewEmpLname(String newEmpLname) {
		this.newEmpLname = newEmpLname;
	}

	public String getNewEmpMail() {
		return newEmpMail;
	}

	public void setNewEmpMail(String newEmpMail) {
		this.newEmpMail = newEmpMail;
	}

	public String getNewEmpSalary() {
		return newEmpSalary;
	}

	public void setNewEmpSalary(String newEmpSalary) {
		this.newEmpSalary = newEmpSalary;
	}

	public String getNewEmpGender() {
		return newEmpGender;
	}

	public void setNewEmpGender(String newEmpGender) {
		this.newEmpGender = newEmpGender;
	}

	public String getNewMngEmpId() {
		return newMngEmpId;
	}

	public void setNewMngEmpId(String newMngEmpId) {
		this.newMngEmpId = newMngEmpId;
	}

	public String getNewEmpStatus() {
		return newEmpStatus;
	}

	public void setNewEmpStatus(String newEmpStatus) {
		this.newEmpStatus = newEmpStatus;
	}

} // class end here --
