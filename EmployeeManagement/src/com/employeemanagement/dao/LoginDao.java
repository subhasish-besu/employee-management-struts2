package com.employeemanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.employeemanagement.dto.EmployeeDetails;

public class LoginDao {

	final private String host = "localhost";
	final private String user = "root";
	final private String passwd = "";
	
	private static LoginDao single_instance = null;
	
	private LoginDao() {
		
	}
	
	public static LoginDao getInstance()
    {
        if (single_instance == null)
            single_instance = new LoginDao();
 
        return single_instance;
    }

	ResultSet rs = null;
	
	static final Logger LOGGER = Logger.getLogger(LoginDao.class);

	// declare loginData function here ---
	public String loginData(EmployeeDetails obj) throws Exception {

		// create a mysql database connection
		String myDriver = "com.mysql.jdbc.Driver";
		String password = null;
		Class.forName(myDriver);

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://" + host + "/employee_management?" + "user=" + user + "&password=" + passwd);

		try {

			// the mysql insert statement
			String query = " select password from t_login_details where EmployeeId = ?";

			// create the mysql insert prepared statement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, obj.getEmpId());
			// preparedStmt.setString (2, obj.getPassword());

			rs = preparedStmt.executeQuery();

			while (rs.next()) {// get first result

				password = rs.getString(1);
			}

			// execute the prepared statement
			preparedStmt.execute();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw e;
		} finally {
			conn.close();
		}

		return password;

	} // function end here ---

				//---------- declare showData function here ------------------
	public EmployeeDetails showData(EmployeeDetails obj) throws ClassNotFoundException, SQLException {

		// create a mysql database connection
		String myDriver = "com.mysql.jdbc.Driver";
		String password = null;
		

		Class.forName(myDriver);
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://" + host + "/employee_management?" + "user=" + user + "&password=" + passwd);

		// the mysql insert statement
		String query = "SELECT *\r\n" + 
				"FROM t_employee_details em\r\n" + 
				"LEFT JOIN t_employee_role emrole ON em.EmployeeId = emrole.EmployeeId\r\n" + 
				"LEFT JOIN t_role role ON emrole.RoleId= role.RoleId\r\n" + 
				"WHERE em.EmployeeId = ?";

		// create the mysql insert prepared statement
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setString(1, obj.getEmpId());
		// preparedStmt.setString (2, obj.getPassword());

		rs = preparedStmt.executeQuery();

		while (rs.next()) {// get first result

			
			obj.setFname(rs.getString(2));
			obj.setLname(rs.getString(3));
			obj.setEmail(rs.getString(4));
			obj.setMngEmpId(rs.getString(7));
			obj.setStatus(rs.getString(8));
			obj.setRoleName(rs.getString("RoleName"));
			obj.setRoleId(rs.getString("RoleId"));

			/*empList.add(emp);
			/*
			 * for(int i =2; i<=4; i++) { //System.out.println(rs.getString(i));//coloumn 1
			 * }
			 */
		}

		return obj;
	}// function end here --
	
	
	private Object EmployeeDetails() {
		// TODO Auto-generated method stub
		return null;
	}

								// ---------------------showAllData FUNCTION	----------------------------
	public ArrayList<EmployeeDetails> showAllData(EmployeeDetails obj) throws ClassNotFoundException, SQLException {

		// create a mysql database connection
		String myDriver = "com.mysql.jdbc.Driver";
		String password = null;
		ArrayList<EmployeeDetails> empList = new ArrayList<EmployeeDetails>();

		Class.forName(myDriver);
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://" + host + "/employee_management?" + "user=" + user + "&password=" + passwd);

		// the mysql insert statement
		String query = "SELECT * FROM t_employee_details";

		// create the mysql insert prepared statement
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		//preparedStmt.setString(1, obj.getEmpId());
		// preparedStmt.setString (2, obj.getPassword());

		rs = preparedStmt.executeQuery();

		while (rs.next()) {// get first result
			
			EmployeeDetails emp = new EmployeeDetails();
			
			emp.setEmpId(rs.getString("EmployeeId"));
			emp.setFname(rs.getString("Fname"));
			emp.setLname(rs.getString("Lname"));
			emp.setEmail(rs.getString("EmailId"));
			emp.setSalary(rs.getString("Salary"));
			emp.setStatus(rs.getString("Status"));
			
			

			empList.add(emp);
			/*
			 * for(int i =2; i<=4; i++) { //System.out.println(rs.getString(i));//coloumn 1
			 * }
			 */
		}

		return empList;
	}// function end here --
	
	public EmployeeDetails insertNewData(EmployeeDetails obj) throws Exception {
		
		// create a mysql database connection
				String myDriver = "com.mysql.jdbc.Driver";
				
				Class.forName(myDriver);

				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://" + host + "/employee_management?" + "user=" + user + "&password=" + passwd);

		
		try {
			
			// the mysql insert statement
						String query = " insert into t_employee_details (EmployeeId, Fname, Lname, EmailId, Salary, Gender, Manager_Employee_Id,Status)" + " values (?, ?, ?,?,?,?,?,?)";
						
						// create the mysql insert prepared statement
					      PreparedStatement preparedStmt = conn.prepareStatement(query);
					      
					      preparedStmt.setString (1, obj.getEmpId());
					      preparedStmt.setString (2, obj.getFname());
					      preparedStmt.setString (3, obj.getLname());
					      preparedStmt.setString (4, obj.getEmail());
					      preparedStmt.setString (5, obj.getSalary());
					      preparedStmt.setString (6, obj.getGender());
					      preparedStmt.setString (7, obj.getMngEmpId());
					      preparedStmt.setString (8, obj.getStatus());
					      
					      // execute the prepared statement
					      preparedStmt.execute();
			
		}catch(Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw e;
		} finally {
			conn.close();
		}
			
		
		
	return obj;
	} // insertNewData function end here ----
	
	
	public EmployeeDetails updateNewData(EmployeeDetails obj) throws ClassNotFoundException, SQLException {
		
		// create a mysql database connection
		String myDriver = "com.mysql.jdbc.Driver";
		
		Class.forName(myDriver);

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://" + host + "/employee_management?" + "user=" + user + "&password=" + passwd);
		
		LOGGER.info("Getting details of  UpdateEmployeeDao->" + obj.getEmpId());

try {
	
	// the mysql update statement
				String query = " UPDATE t_employee_details SET Fname=?, Lname=?, EmailId=?, Manager_Employee_Id=?, Status=? WHERE EmployeeId = ?" ;
				// create the mysql insert prepared statement
			      PreparedStatement preparedStmt = conn.prepareStatement(query);
			      
			      preparedStmt.setString (1, obj.getFname());
			      preparedStmt.setString (2, obj.getLname());
			      preparedStmt.setString (3, obj.getEmail());
			      preparedStmt.setString (4, obj.getMngEmpId());
			      //preparedStmt.setString (5, obj.getSalary());
			      //preparedStmt.setString (6, obj.getGender());
			      preparedStmt.setString (5, obj.getStatus());
			      preparedStmt.setString (6, obj.getEmpId());
			      
			      // execute the prepared statement
			      preparedStmt.execute();
			      //conn.commit();
}catch(Exception e) {
	// TODO Auto-generated catch block
	// e.printStackTrace();
	throw e;
} finally {
	
	conn.close();
}
		
		return obj;
		
		
	} //end updateNewData function here ---
	
	

} // end class here ---
