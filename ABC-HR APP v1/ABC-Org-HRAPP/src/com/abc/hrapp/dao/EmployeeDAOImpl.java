package com.abc.hrapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.abc.hrapp.entity.Employee;

public class EmployeeDAOImpl implements IEmployeeDAO{

	Connection con = DBConnection.con;
	
	@Override
	public boolean addEmployee(Employee e)throws Exception
	{
		String query = " insert into employee values(?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(query); // use to hit the database , with pre compiled DB Queries
		ps.setInt(1, e.getEmpId());
		ps.setString(2, e.getEmpname());
		ps.setInt(3, e.getSalary());
		ps.setString(4, e.getDepartment());
		
		int i = ps.executeUpdate(); // returns the number of rows effected
		
		if(i == 1) return true;
		else return false;
	}

	@Override
	public Employee getEmployeeById(int searchId) throws Exception {
		String query = "select * from Employee where empid = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, searchId);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			int id = rs.getInt("empid");
			String name= rs.getString("empname");
			int salary = rs.getInt("salary");
			String dept= rs.getString("department");
			
			Employee e = new Employee(id, name, salary, dept);
			return e;
		}
		
		
		return null;
	}

	@Override
	public List<Employee> getEmployeeByDepartment(String searchDepartmentName) {
		
		return null;
	}

	@Override
	public boolean deleteEmployee(int searchId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployeeSalary(int searchId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployeeSalary(String department) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
