/**
 * 
 */
package com.employeemanagement.dto;

/**
 * @author USER
 *
 */
public class WeatherDTO {

	
	private String curTemp;
	public String getCurTemp() {
		return curTemp;
	}
	public void setCurTemp(String curTemp) {
		this.curTemp = curTemp;
	}
	public String getMaxTemp() {
		return maxTemp;
	}
	public void setMaxTemp(String maxTemp) {
		this.maxTemp = maxTemp;
	}
	public String getMinTemp() {
		return minTemp;
	}
	public void setMinTemp(String minTemp) {
		this.minTemp = minTemp;
	}
	private String maxTemp;
	private String minTemp;
	
	
	
}
