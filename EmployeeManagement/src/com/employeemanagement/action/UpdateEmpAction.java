package com.employeemanagement.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.employeemanagement.business.EmployeeBusiness;
import com.employeemanagement.dto.EmployeeDetails;



public class UpdateEmpAction implements SessionAware{
	
	private String updateId;
	private String updateFname;
	private String updateLname;
	private String updateEmail;
	private String updateMngId;
	private String updateStatus;
	
	private Map<String, Object> session;	
	private String errorMsg;
	
	
	EmployeeDetails updateEp = new EmployeeDetails();	
	
	// add logger here---
			static final Logger LOGGER = Logger.getLogger(UpdateEmpAction.class);
	
	public String execute() {
		
		EmployeeBusiness data = new EmployeeBusiness();
		
		try {
			
			LOGGER.info("In execute of UpdateEmpAction -> " + updateId);
			
			updateEp.setEmpId(updateId);
			updateEp.setFname(updateFname);
			updateEp.setLname(updateLname);
			updateEp.setEmail(updateEmail);
			//updateEp.setSalary(newEmpSalary);
			//updateEp.setGender(newEmpGender);
			updateEp.setMngEmpId(updateMngId);
			updateEp.setStatus(updateStatus);
			
			
			
			updateEp = data.getUpdateEmployee(updateEp);
			
		 
		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				LOGGER.error(e.getMessage(), e);
				return "error";
			}
			
			LOGGER.info("Exit on UpdateEmpAction ->");				
		
		return "home";
	} // execute function end here --



	public String getUpdateId() {
		return updateId;
	}



	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}



	public String getUpdateFname() {
		return updateFname;
	}



	public void setUpdateFname(String updateFname) {
		this.updateFname = updateFname;
	}



	public String getUpdateLname() {
		return updateLname;
	}



	public void setUpdateLname(String updateLname) {
		this.updateLname = updateLname;
	}



	public String getUpdateEmail() {
		return updateEmail;
	}



	public void setUpdateEmail(String updateEmail) {
		this.updateEmail = updateEmail;
	}



	public String getUpdateMngId() {
		return updateMngId;
	}



	public void setUpdateMngId(String updateMngId) {
		this.updateMngId = updateMngId;
	}



	public String getUpdateStatus() {
		return updateStatus;
	}



	public void setUpdateStatus(String updateStatus) {
		this.updateStatus = updateStatus;
	}



	public String getErrorMsg() {
		return errorMsg;
	}



	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}



	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

}
