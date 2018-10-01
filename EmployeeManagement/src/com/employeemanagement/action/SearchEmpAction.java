package com.employeemanagement.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.employeemanagement.business.EmployeeBusiness;
import com.employeemanagement.dto.EmployeeDetails;

public class SearchEmpAction implements SessionAware {

	EmployeeDetails empAudit = new EmployeeDetails();
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

	public EmployeeDetails getEmpAudit() {
		return empAudit;
	}

	public void setEmpAudit(EmployeeDetails empAudit) {
		this.empAudit = empAudit;
	}

	// add logger here---
	static final Logger LOGGER = Logger.getLogger(SearchEmpAction.class);

	public String execute() {

		String searchEmpId = "";
		EmployeeBusiness data = new EmployeeBusiness();
		try {
			if (null != session.get("userObj")) {
				LOGGER.info("In execute of SearchEmpAction -> userObj is present in session ");
				LOGGER.info("SearchEmployeeAction : searchEmpId-> " + searchEmpId);
				searchEmpId = ServletActionContext.getRequest().getParameter("searchEmpId");
				empAudit.setEmpId(searchEmpId);
				empAudit = data.getEmployeeDetails(empAudit);
				
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
		
		LOGGER.info("Exit on SearchEmployeeAction ->" + searchEmpId);
		return "showAudit";
	}// execute function end here --
}
