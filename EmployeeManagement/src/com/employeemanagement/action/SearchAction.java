package com.employeemanagement.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

public class SearchAction implements SessionAware {
	
	
	
	// add logger here---
		static final Logger LOGGER = Logger.getLogger(SearchAction.class);
	
	public String execute() {
		
		//System.out.println("Employee Id "+ empId);
		
		LOGGER.info("entry on SearchAction class	 ");
		return "success";
		
	}

	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
