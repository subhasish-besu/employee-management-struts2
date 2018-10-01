<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>New employee form</title>
</head>
<body>

<div class="container">
 	<div class="row">
 		<div class="col-sm-2"></div>
 		<div class="col-sm-8">
 		
 			<form action="newEmp" method="post">
 			
 			
 			<div class="panel panel-success">
 				<div class="panel-heading text-center">Create an account</div>
 				<div class="panel-body">
 				
 				<div class="form-group"> 	
	 				<div class="row">	
	 					<div class="col-sm-4">
	 						<label>Employee Id:</label>
	 					</div>	
	 					<div class="col-sm-8">
	 							<input type="text" name="newEmpId" class="form-control" placeholder="Enter employee id"> <br>
	 					</div>
	 				</div>
 				</div>	<!-- employee id end here  -->			
 				
 				<div class="form-group"> 	
	 				<div class="row">	
	 					<div class="col-sm-4">
	 						<label>First Name:</label>
	 					</div>	
	 					<div class="col-sm-8">
	 							<input type="text" name="newEmpFname" class="form-control" placeholder="Enter first name"> <br>
	 					</div>
	 				</div>
 				</div>	<!-- first name end here  -->
 				
 				<div class="form-group"> 	
	 				<div class="row">	
	 					<div class="col-sm-4">
	 						<label>Last Name:</label>
	 					</div>	
	 					<div class="col-sm-8">
	 							<input type="text" name="newEmpLname" class="form-control" placeholder="Enter last name"> <br>
	 					</div>
	 				</div>
 				</div>	<!-- last name end here  -->
 				
 				<div class="form-group"> 	
	 				<div class="row">	
	 					<div class="col-sm-4">
	 						<label>Email Id:</label>
	 					</div>	
	 					<div class="col-sm-8">
	 							<input type="text" name="newEmpMail" class="form-control" placeholder="Enter email id"> <br>
	 					</div>
	 				</div>
 				</div>	<!-- email end here  -->
 				
 				<div class="form-group"> 	
	 				<div class="row">	
	 					<div class="col-sm-4">
	 						<label>Salary:</label>
	 					</div>	
	 					<div class="col-sm-8">
	 							<input type="text" name="newEmpSalary" class="form-control" placeholder="Enter salary"> <br>
	 					</div>
	 				</div>
 				</div>	<!-- salary end here  -->
 				
 				<div class="form-group"> 	
	 				<div class="row">	
	 					<div class="col-sm-4">
	 						<label>Gender:</label>
	 					</div>	
	 					<div class="col-sm-8">
	 							<input type="radio" name="newEmpGender" value="Male">Male 	&nbsp
	 							<input type="radio" name="newEmpGender" value="Female">Female
	 							
	 					</div>
	 				</div>
 				</div>	<!-- gender end here  -->
 				
 				<div class="form-group"> 	
	 				<div class="row">	
	 					<div class="col-sm-4">
	 						<label>Manager Employee Id:</label>
	 					</div>	
	 					<div class="col-sm-8">
	 							<input type="text" name="newMngEmpId" class="form-control" placeholder="Enter manager employee id"> <br>
	 					</div>
	 				</div>
 				</div>	<!-- manager employee id end here  -->
 				
 				<div class="form-group"> 	
	 				<div class="row">	
	 					<div class="col-sm-4">
	 						<label>Status:</label>
	 					</div>	
	 					<div class="col-sm-8">
	 							 							
	 							<input type="radio" name="newEmpStatus" value="active">Active 	&nbsp
	 							<input type="radio" name="newEmpStatus" value="inactive">Inactive
	 					</div>
	 				</div>
 				</div>	<!-- status end here  -->
 				
 				<div class="form-group text-center">
 				<input type="submit" class="btn btn-md btn-success" value="Submit" >	
 				</div>
 				</div><!-- panel-body end -->
 			</div> <!-- Panel end here  -->
 			</form> 			
 		
 		</div>
 		
 		
 		<div class="col-sm-2"></div>
 	
 	</div>
 </div> <!--container end   -->
 

</body>
</html>