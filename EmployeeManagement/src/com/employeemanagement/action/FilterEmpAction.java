package com.employeemanagement.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.employeemanagement.business.EmployeeBusiness;
import com.employeemanagement.dto.EmployeeDetails;

public class FilterEmpAction implements SessionAware {
	
	EmployeeDetails empFilter = new EmployeeDetails();	
	ArrayList<EmployeeDetails> empFilters;
	public ArrayList<EmployeeDetails> getEmpFilters() {
		return empFilters;
	}

	public void setEmpFilters(ArrayList<EmployeeDetails> empFilters) {
		this.empFilters = empFilters;
	}

	public EmployeeDetails getEmpFilter() {
		return empFilter;
	}

	public void setEmpFilter(EmployeeDetails empFilter) {
		this.empFilter = empFilter;
	}

	private Map<String, Object> session;
	private String errorMsg;
	
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	// add logger here---
		static final Logger LOGGER = Logger.getLogger(FilterEmpAction.class);
	
	
	public String execute() {
		EmployeeBusiness data = new EmployeeBusiness();
		String filterSalary = "";
		
		
		try {
			if (null != session.get("userObj")) {
				LOGGER.info("In execute of SearchEmpAction -> userObj is present in session ");
				LOGGER.info("SearchEmployeeAction : searchEmpId-> " + filterSalary);
				filterSalary = ServletActionContext.getRequest().getParameter("filterSalary");
				 try {
					if(filterSalary.equalsIgnoreCase("Hsalary")) {
						empFilters = data.getAllEmployeeHsalaryDetails(empFilter); // go to Business class
						
					}else if(filterSalary.equalsIgnoreCase("Lsalary")) {
						
						empFilters = data.getAllEmployeeLsalaryDetails(empFilter); // go to Business class
					}else {
						errorMsg = "Select correct salary option";
					}
				 }catch(Exception e){
						// TODO Auto-generated catch block
						//e.printStackTrace();
						LOGGER.error(e.getMessage(), e);
						return "error";
					}
				 return "showFilter";
				
			} else {
				LOGGER.info("In execute of SearchEmpAction -> userObj is not present in session -> redirect to login page");
				errorMsg = "Session has timed out. Login again";
				return "login";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			LOGGER.error(e.getMessage(), e);
			return "error";
		}
		
		//LOGGER.info("Exit on SearchEmployeeAction ->" + filterSalary);
		
		
		
		
		//return "showFilter";
	}

	
}
