<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Filter employee</title>

<script>

		function myFunction() {
			var x = document.getElementById("mySelect").value;
			//document.getElementById("demo").innerHTML = "You selected: " + x;    

			$.ajax({
				type : "POST",
				url : 'FilterEmpAction?filterSalary=' + x,
				success : function(result) {
					if (result != null && result.length > 0) {

						$("#demo").html(result);
					}
				},
				error : function(xhr, errmsg) {
					alert("Nothing found!!");
				}
			});
		}
	</script>
	
</head>
<body>
	<br><br>

	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8 text-center">

			<div class="input-group">
				<select>
					<option>All employees</option>
					<option>Only staff</option>
					<option>Only administrator</option>
				</select> <select id="mySelect" onchange="myFunction()">
					<option>Select Salary</option>
					<option value="Hsalary">Highest Salary</option>
					<option value="Lsalary">Lowest Salary</option>
				</select>

				<!-- 
	      			<div class="input-group-btn">
	        			<button class="btn btn-sm btn-success" onclick="empSearch(document.getElementById('empId').value)">Search</button>
	      			</div>
	      			 -->

			</div>


		</div>
		
		
		<div class="col-sm-2">
			<a href="home"><span class="glyphicon glyphicon-home"></span></a>
		</div>
		
	</div> <br><br>
	
	<div class="row">
		<div class="col-sm-12">		
			<div id="demo"></div>		
		</div>
	</div>
	
	
</body>
</html>