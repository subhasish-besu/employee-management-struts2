$(document).ready(function() {
  
  $("#regis").validate({
    
    rules: {
      
      name: "required",
      
      mobile: {
          required: true,
          
          mobile: true
        },
      
      msg: {
        required: true,
        
        msg: true
      },
      
      
    },
    // Specify validation error messages
    messages: {
      name: "Please enter your name",
      
      mobile:"Please enter your mobile no",
      msg: "Please enter a valid email address"
    },
    
    
  });
});