package com.employeemanagement.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.log4j.Logger;

import com.employeemanagement.dao.LoginDao;
import com.employeemanagement.dto.EmployeeDetails;

public class EmployeeBusiness{

	static final Logger LOGGER = Logger.getLogger(EmployeeBusiness.class);

	public EmployeeDetails checkLogin(EmployeeDetails obj) throws Exception {

		try {
			LoginDao data = LoginDao.getInstance();

			String pass = data.loginData(obj); // going to DAO class

			LOGGER.info("Provided empId->" + obj.getEmpId());
			LOGGER.info("Provided password->" + obj.getPassword());
			LOGGER.info("DataBase Password->" + pass);

			if (null != obj.getPassword() && obj.getPassword().equals(pass)) {
				obj.setLoginStatus(true);
				obj = data.showData(obj);
				
			} else if(null != obj.getPassword() && !obj.getPassword().equals(pass)) {
				obj.setLoginStatus(false);
				LOGGER.info("Entry wrong password");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw e;
		}

		return obj;
	}
	
	public EmployeeDetails getEmployeeDetails(EmployeeDetails obj) throws Exception {
		LOGGER.info("Getting details for empId->" + obj.getEmpId());
		try {
			LoginDao data = LoginDao.getInstance();
			obj = data.showData(obj);
		}catch (ClassNotFoundException | SQLException e) {
			throw e;
		}

		return obj;
	} // function end here --
	
	public EmployeeDetails getNewEmployee(EmployeeDetails obj) throws Exception {
		LOGGER.info("Getting details of New Employee->" + obj.getEmpId());
		
		try {
			
			LoginDao data = LoginDao.getInstance();
			obj = data.insertNewData(obj);
			
		}catch (ClassNotFoundException | SQLException e){
			throw e;
		}
		
		return obj;
	} // function end here --
	
	public EmployeeDetails getUpdateEmployee(EmployeeDetails obj) throws Exception {		
		LOGGER.info("Getting details of  UpdateEmployeeBusiness->" + obj.getEmpId());
		
			try {
			
				LoginDao data = LoginDao.getInstance();
				obj = data.updateNewData(obj);
			
				}catch (ClassNotFoundException | SQLException e){
					throw e;
				}
		
		return obj;
	} // function end here--
	
		//--------------------- Highest Salary Employee -----------------------------------------------------
	public ArrayList<EmployeeDetails> getAllEmployeeHsalaryDetails(EmployeeDetails obj) throws Exception {
		
		ArrayList<EmployeeDetails> empHlist;
		
		
		LOGGER.info("Getting details for Highest Salary here ->");
		try {
			LoginDao data = LoginDao.getInstance();
			empHlist = data.showAllData(obj);
			
			//------------- Add collection List here --------------------
			
			Collections.sort(empHlist,Collections.reverseOrder());

			
			
		}catch (ClassNotFoundException | SQLException e) {
			throw e;
		}

		return empHlist;
	} // function end here --
	
	//--------------------- Lowest Salary Employee -----------------------------------------------------
public ArrayList<EmployeeDetails> getAllEmployeeLsalaryDetails(EmployeeDetails obj) throws Exception {
	ArrayList<EmployeeDetails> empLlist;
		LOGGER.info("Getting details for Lowest Salary here ->");
		try {
			LoginDao data = LoginDao.getInstance();
			empLlist = data.showAllData(obj);
			
			//--------------- Add collection List here---------			
				Collections.sort(empLlist);
			
			
			
		}catch (ClassNotFoundException | SQLException e) {
			throw e;
		}

		return empLlist;
	} // function end here --
	

}// end class here ---
