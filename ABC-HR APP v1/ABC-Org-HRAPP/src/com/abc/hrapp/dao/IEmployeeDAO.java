package com.abc.hrapp.dao;

import java.util.List;

import com.abc.hrapp.entity.Employee;

public interface IEmployeeDAO {
	public boolean addEmployee(Employee e); // method to add Employee in DB
	public Employee getEmployeeById(int searchId);
	public List<Employee> getEmployeeByDepartment(String searchDepartmentName);
	public boolean deleteEmployee(int searchId);
	public boolean updateEmployeeSalary(int searchId);
	public boolean updateEmployeeSalary(String department);
}