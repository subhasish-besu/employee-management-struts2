package com.employeemanagement.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;




public class FilterAction implements SessionAware{
	private Map<String, Object> session;
	static final Logger LOGGER = Logger.getLogger(FilterAction.class);
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
	
	public String execute() {
		if (null != session.get("userObj")) {
			LOGGER.info("In execute of FilterAction -> userObj is present in session ");
			return "success";
			
		} else {
			LOGGER.info("In execute of FilterAction -> userObj is not present in session -> redirect to login page");
			errorMsg = "Session has timed out. Login again";
			return "login";
		}
	}



}
