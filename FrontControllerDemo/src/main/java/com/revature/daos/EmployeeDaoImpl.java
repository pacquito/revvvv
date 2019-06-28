package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Department;
import com.revature.models.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	List<Employee> employees = new ArrayList<>();
	
	DepartmentDao deptDao = new DepartmentDaoImpl();
	
	public EmployeeDaoImpl() {
		employees.add(new Employee(1, "John Wick", 1500, 3));
		employees.add(new Employee(2, "Hannah Jones", 1000, 1));
		employees.add(new Employee(3, "Jane Doe", 980, 2));
		employees.add(new Employee(4, "John Doe", 2500, 2));
		employees.add(new Employee(5, "Ricky Flicky", 300, 4));
		employees.add(new Employee(6, "Wick John", 80, 3));

	}

	//in getEmployees we add meaningful information about the department to each employee so that we know more than just the department ID
	@Override
	public List<Employee> getEmployees() {
		for(Employee e: employees) {
			for(Department d: deptDao.getDepartments()) {
				if(e.getDepartment()!=null && e.getDepartment().getId() == d.getId()) {
					e.setDepartment(d);
				}
			}
		}
		
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = null;
		for(Employee e : employees) {
			if(e.getId() == id) {
				employee = e;
			}
		}
		if(employee!=null && employee.getDepartment() != null) {
			employee.setDepartment(deptDao.getDepartmentById(employee.getDepartment().getId()));
		}
		return employee;
	}

	@Override
	public int createEmployee(Employee e) {
		int maxId = 0;
		for(Employee emp : employees) {
			if(emp.getId() > maxId) {
				maxId = emp.getId();
			}
		}
		e.setId(maxId+1);
		employees.add(e);
		return 1;
	}

	@Override
	public int updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
