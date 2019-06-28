package com.revature.services;

import java.util.List;

import com.revature.daos.DepartmentDao;
import com.revature.daos.DepartmentDaoImpl;
import com.revature.models.Department;

public class DepartmentService {

	private DepartmentDao dptDao = new DepartmentDaoImpl();
	
	//ideally we'd want all of our crud methods
	//using this department service to dynamically get departments for our select drow down
	
	public List<Department> getAll(){
		return dptDao.getDepartments();
	}
}
