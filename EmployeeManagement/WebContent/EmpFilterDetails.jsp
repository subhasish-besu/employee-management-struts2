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
<title>Employee Filter Details</title>
<style>
	#errorMsg { color: red;}

</style>
</head>
<body>


	<div class="row">

	<div class="col-sm-2"></div>
	
	
	<div class="col-sm-8">	
				<div class="form-group" id="errorMsg"> 
 					<s:property value="errorMsg"/> <!-- Error msg display  -->				
 				</div>

		<table border=1 class="table table-striped">
				<thead>
					<tr>				
							<caption class="text-center"><strong><u>Employees Salary</u></strong></caption>				
					</tr>	
				
				</thead>
				<tbody>
				<tr>
					<th>First Name</th>
					<th>Last Name </th>
					<th>Email Id</th>
					<th>Salary</th>
					
				</tr>
				<s:iterator var="i" step="1" value="empFilters">
				<tr>	
					<td>			
						<s:property value="fname"/>    
					</td>
					<td>			
						<s:property value="lname"/>    
					</td>
					<td>			
						<s:property value="email"/>    
					</td>
					<td>			
						<s:property value="salary"/>    
					</td>
				</tr>				
				</s:iterator>
				
				</tbody>			
				
		</table>
		
			      
		
		
	</div>
	<div class="col-sm-2"></div>
</div> <!-- row end here -->	
	
</body>
</html>