<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags" %>

  <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
  
  
  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee login</title>
<script type="text/javascript">

</script>
</head>

<body>
<br><br>
 
 
 <div class="container">
 	<div class="row">
 		<div class="col-sm-4"></div>
 		<div class="col-sm-4">
 		
 			<form action="login" method="post">
 			
 			
 			<div class="panel panel-success">
 				<div class="panel-heading text-center">Please Login</div>
 				<div class="panel-body">
 				
 				
 				<div class="form-group"> 
 				<s:property value="errorMsg"/> <!-- Error msg display  -->				
 				</div>
 				
 				<div class="form-group"> 				
 				<input type="text" name="userEmpId" class="form-control" placeholder="Employee Id"> <br>
 				</div>
 				
 				<div class="form-group"> 				
 				<input type="text" name="userPassword" class="form-control" placeholder="Password"> <br>
 				</div>				
 				
 				
 				<div class="form-group">
 				<input type="submit" class="btn btn-success form-control " value="Login" >	
 				</div>
 				</div><!-- panel-body end -->
 			</div> <!-- Panel end here  -->
 			</form> 
 			 		
 		</div>
 		
 		
 		<div class="col-sm-4"></div>
 	
 	</div>
 </div> <!--container end   -->
 
 
</body>
</html>