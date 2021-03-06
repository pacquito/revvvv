package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class EmployeeDelegate {
	
	EmployeeService eService = new EmployeeService();
	
	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Employee> employees = eService.getAll();
		
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(employees));
		pw.close();
		
	}
	
	public void createEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String newName = request.getParameter("name");
		String newDeptIdStr = request.getParameter("department");
		System.out.println("Input "+newName + " with a deptId of "+newDeptIdStr);
		
		if(newDeptIdStr != null && newDeptIdStr.matches("^\\d+$")) {
			Employee e = new Employee();
			e.setName(newName);
			e.getDepartment().setId(Integer.parseInt(newDeptIdStr));
			eService.create(e);
			
//			response.setStatus(201);
			response.sendRedirect("../directory");
		}
	}

}
