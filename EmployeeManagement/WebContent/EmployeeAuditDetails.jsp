<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
   <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Audit details</title>
</head>
<body>


<div class="row">

	<div class="col-sm-3"></div>
	
	
	<div class="col-sm-6">
	
		<form action="UpdateEmp" method="post">

		<table border=1 class="table table-striped">
				<thead>
					<tr>				
							<caption class="text-center"><strong><u>Employee Audit Details</u></strong></caption>				
					</tr>	
				
				</thead>
				<tbody>
				<tr>
					<th>Employee-Id</th>
					<td>			
					<input type="text" value="<s:property  value="empAudit.empId"/>" name="updateId">   
					</td>
				</tr>
				<tr>	
					<th>First Name</th>
					<td>
					  <input type="text" value="<s:property value="empAudit.fname"/>" name="updateFname">  
					 </td>
				</tr>	
				<tr>
					<th>Last Name</th>
					<td> 
						<input type="text" value="<s:property value="empAudit.lname"/>" name="updateLname"> 			
					</td>
				</tr>
				<tr>	
					<th>Email-Id</th>
					<td> 
						<input type="text" value="<s:property value="empAudit.email"/>" name="updateEmail"> 			
					</td>
				</tr>
				<tr>	
					<th>Manager Employee Id</th>
					<td> 
						<input type="text" value="<s:property value="empAudit.mngEmpId"/>" name="updateMngId"> 			
					</td>
				
				</tr>
				
				<tr>	
					<th>Status</th>
					<td> 
						<input type="text" value="<s:property value="empAudit.status"/>" name="updateStatus"> 			
					</td>
				
				</tr>
				
				<tr >
					<td colspan="2" class="text-center">
						<input type="submit" class="btn btn-success" value="Update">
					</td>				
				</tr>
				</tbody>			
				
		</table>
		
		</form>
	</div>
	<div class="col-sm-3"></div>
</div> <!-- row end here -->	

</body>
</html>