package com.employeemanagement.action;

import com.employeemanagement.business.EmployeeBusiness;
import com.employeemanagement.dto.EmployeeDetails;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LoginCheckAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userEmpId;
	private String userPassword;
	private Map<String, Object> session;
	EmployeeDetails ep = new EmployeeDetails();
	private String errorMsg;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getUserEmpId() {
		return userEmpId;
	}

	public void setUserEmpId(String userEmpId) {
		this.userEmpId = userEmpId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public EmployeeDetails getEp() {
		return ep;
	}

	public void setEp(EmployeeDetails ep) {
		this.ep = ep;
	}

	// add logger here---
	static final Logger LOGGER = Logger.getLogger(LoginCheckAction.class);

	public String execute() {
		try {
			LOGGER.info("Entry in execute of LoginCheck:");
			LOGGER.info("Entry of User ID-" + userEmpId);
			// declare 'data' object of a Business Class here --
			EmployeeBusiness data = new EmployeeBusiness();

			// setting the userid and password coming from jsp page
			ep.setEmpId(userEmpId);
			ep.setPassword(userPassword);

			ep = data.checkLogin(ep);// going to business class

			if (ep.isLoginStatus()) {

				// add SESSION here ---
				LOGGER.info("Password matched -> redirect to home action");
				session.put("userObj", ep);
				return "success";

			} else {
				LOGGER.info("Password not matched -> redirect to login page");
				errorMsg = "Invalid combination of userid and password!";
				return "fail";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error(e.getMessage(), e);
			return "error";
		}

	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}// LoginCheck class end here ---
