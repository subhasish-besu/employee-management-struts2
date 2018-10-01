
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Employee details</title>
<style>

a: link {text-decoration: none;}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 200px;
    background-color: #f1f1f1;
    border: 1px solid #555;
}

li a {
    display: block;
    color: #000;
    padding: 8px 16px;
    text-decoration: none;
}

li {
    text-align: center;
    border-bottom: 1px solid #555;
}

li:last-child {
    border-bottom: none;
}

li a.active {
    background-color: #4CAF50;
    color: white;
}

li a:hover:not(.active) {
    background-color: #555;
    color: white;
}


</style>

</head>

<body>

<br><br>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
				<label> Welcome <font color="blue"><s:property value="#session.userObj.fname"/></font></label>&nbsp &nbsp <a href="index.jsp"><font color="red">Logout</font></a> <br>
				<label> Role <font color="blue"><s:property value="#session.userObj.roleName"/></font> </label><br>
				
					
		</div>
	</div>
	
	<div class="container">
	<div class="row">	
	<div class="col-sm-3"> <!-- write if else condition  -->
			<ul>
			<s:if test="%{#session.userObj.roleId == 101}">
				
					<li><a class="active" href="home">Home</a></li>
				  	<li><a href="CreateAccount">Create new employee</a></li>
				  	<li><a href="#contact">My profile</a></li>
				  	<li><a href="search">Search</a></li>
				  	<li><a href="filter">Search By Filter</a></li>
			  	
			</s:if>
			</ul>
			<ul>
			<s:elseif test="%{#session.userObj.roleId == 201}">				
				  	<li><a class="active" href="home">Home</a></li>			  
				  	<li><a href="#contact">My profile</a></li>
				  	<li><a href="search">Search</a></li>	
				  	<li><a href="filter">Add Filter</a></li>		  
			</s:elseif>
			</ul>	
	
	</div> 
	<div class="col-sm-6 text-center">
	<table border=1 class="table table-striped">
		<thead>
			<tr>				
					<caption class="text-center"><strong><u>Employee Details</u></strong></caption>				
			</tr>	
		
		</thead>
		<tbody>
		<tr>
			<th>Employee-Id</th>
			<td>			
			<s:property value="ep.empId"/>   
			</td>
		</tr>
		<tr>	
			<th>First Name</th>
			<td>
			  <s:property value="ep.fname"/>  
			 </td>
		</tr>	
		<tr>
			<th>Last Name</th>
			<td> 
			<s:property value="ep.lname"/> 			
			</td>
		</tr>
		<tr>	
			<th>Email-Id</th>
			<td> 
			<s:property value="ep.email"/> 			
			</td>
		</tr>
		<tr>	
			<th>Manager Employee Id</th>
			<td> 
			<s:property value="ep.mngEmpId"/> 			
			</td>
		
		</tr>
		
		<tr>	
			<th>Status</th>
			<td> 
			<s:property value="ep.status"/> 			
			</td>
		
		</tr>
		</tbody>
		
	</table>		
	</div>
	<div class="col-sm-3">
			
				<label> Current Temperature <font color="blue"><s:property value="weather.curTemp"/></font> </label><br>
				<label> Minimum Temperature <font color="blue"><s:property value="weather.minTemp"/></font> </label><br>
				<label> Maximum Temperature <font color="blue"><s:property value="weather.maxTemp"/></font> </label><br>
	
	
	</div>
	</div>
</div> <!-- container end here -->
	
	
	
</body>
</html>
	