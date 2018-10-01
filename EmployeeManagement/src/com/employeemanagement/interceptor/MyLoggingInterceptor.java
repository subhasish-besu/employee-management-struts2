package com.employeemanagement.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.employeemanagement.dto.EmployeeDetails;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;


public class MyLoggingInterceptor implements Interceptor{
	
	private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation invocation) throws Exception {

		String className = invocation.getAction().getClass().getName();
		long startTime = System.currentTimeMillis();
		System.out.println("Before calling action: " + className);

		
		final ActionContext context = invocation.getInvocationContext();
		/*HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
		HttpSession session = request.getSession(false);*/
		HttpSession session = ServletActionContext.getRequest().getSession();
		String result = "";
		// Is there a "user" object stored in the user's HttpSession?
		
		
		
		 String actionName = invocation.getInvocationContext().getName();
		
		
		
		if ((null != session && null != (EmployeeDetails) session.getAttribute("userObj")) || actionName.equalsIgnoreCase("login")) {
			System.out.println("session present or actionName is login");
			result = invocation.invoke();
		}else {
			System.out.println("session not present");
			result =  "timeout";
		}
		
		
		long endTime = System.currentTimeMillis();
		System.out.println("After calling action: " + className
				+ " Time taken: " + (endTime - startTime) + " ms");

		return result;
	}

	public void destroy() {
		System.out.println("Destroying MyLoggingInterceptor...");
	}

	public void init() {
		System.out.println("Initializing MyLoggingInterceptor...");
	}


}
