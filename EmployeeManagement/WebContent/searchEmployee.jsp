<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>   
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script>
	
	function empSearch(empId){
		var empId = empId;
		//alert(empId);
		
		$.ajax({
               type : "POST",               
               url: 'SearchEmpAction?searchEmpId='+empId,               
               success : function(result){
                 if (result != null && result.length > 0){
                   
                   $("#statesdivid").html(result);
                 }
               },
               error : function(xhr, errmsg) {alert("Nothing found!!");}
           });    
	}
	
	</script>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search employee</title>
</head>


<body>
<br><br>

	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			
				<div class="input-group">
      				<input type="text" class="form-control input-md" placeholder="Enter Employee Id" name="empId" id="empId">
	      			<div class="input-group-btn">
	        			<button class="btn btn-md btn-default" onclick="empSearch(document.getElementById('empId').value)">Search</button>
	      			</div>
    			</div>
		
		
		</div>
		
		<!-- HOME icon here  -->
		<div class="col-sm-3">
			<a href="home"><span class="glyphicon glyphicon-home"></span></a>
		</div>
		
	</div>
	
	<div class="row">
		<div class="col-sm-12">
			<div id="statesdivid"></div>		
		</div>
	</div>
	
</body>
</html>