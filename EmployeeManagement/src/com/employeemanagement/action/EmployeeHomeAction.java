package com.employeemanagement.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.employeemanagement.common.EmployeeManagementCommon;
import com.employeemanagement.dto.EmployeeDetails;
import com.employeemanagement.dto.WeatherDTO;

public class EmployeeHomeAction implements SessionAware {

	// Declare session here ---
	private Map<String, Object> session;
	private String errorMsg;
	WeatherDTO weather;
	private String zipCode;

	public WeatherDTO getWeather() {
		return weather;
	}

	public void setWeather(WeatherDTO weather) {
		this.weather = weather;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	// declare 'ep' object of a DTO class here ---
	EmployeeDetails ep = new EmployeeDetails();

	public EmployeeDetails getEp() {
		return ep;
	}

	public void setEp(EmployeeDetails ep) {
		this.ep = ep;
	}

	// add logger here---
	static final Logger LOGGER = Logger.getLogger(EmployeeHomeAction.class);

	// define 'execute' function here --
	public String execute() {

		LOGGER.info("Entry in execute of Home:");

		
			
			LOGGER.info("In execute of Home -> userObj is present in session -> redirect to home page");
			ep = (EmployeeDetails) session.get("userObj");
			
			String zip = "560036";
			weather = EmployeeManagementCommon.getWeather(zip);
			return "home";
			
		

	} // end 'execute' function here ---

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	

}
