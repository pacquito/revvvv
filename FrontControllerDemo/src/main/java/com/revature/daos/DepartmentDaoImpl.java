package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Department;

public class DepartmentDaoImpl implements DepartmentDao{
	
	List<Department> departments = new ArrayList<>();
	
	public DepartmentDaoImpl() {
		departments.add(new Department(1, "Marketing", 9696));
		departments.add(new Department(2, "Human Resources", 3100));
		departments.add(new Department(3, "Public Relations", 5555));
		departments.add(new Department(4, "Legal", 1000000));

	}

	@Override
	public List<Department> getDepartments() {
		return new ArrayList<Department>(departments);
	}

	@Override
	public Department getDepartmentById(int id) {
		for(Department d : departments) {
			if(d.getId() == id) {
				return d;
			}
		}
		return null;
	}

	@Override
	public int createDepartment(Department d) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateDepartment(Department d) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDepartment(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
