package com.abc.hrapp;

import java.util.Random;
import java.util.Scanner;

import com.abc.hrapp.entity.Employee;
import com.abc.hrapp.service.EmployeeServiceImpl;
import com.abc.hrapp.service.IEmployeeService;

public class MainApp {

	Scanner sc = new Scanner(System.in);
	Scanner strSc = new Scanner(System.in);
	
	// Animal a = new Dog();
	IEmployeeService service = new EmployeeServiceImpl();
	
	
	public static void main(String[] args) {
		
		MainApp app = new MainApp();
		 
		while(true)
		{
			
			System.out.println(" --------- MENU ---------");
			
			System.out.println("1. Add Employee ");
			System.out.println("2. Get Employee By ID ");
			System.out.println("0. EXIT ");
			
			System.out.println("Enter Choice ");
			
			switch (new Scanner(System.in).nextInt()) {
			case 1:
				app.insertEmployee();
				break;
				
				
			case 2:
				app.getEmployeeById();
				break;

			case 0:
				System.exit(0);
			default:
				break;
			}
			
		}//end of while
		
	}//end of main
	
	
	public void insertEmployee()
	{
		System.out.println("Enter Employee Name ");
		String empName = strSc.nextLine();
	
		System.out.println("Enter Employee Department ");
		String department = strSc.nextLine();
		
		System.out.println("Enter Employee Salary ");
		int salary = sc.nextInt();
		
		int id = new Random().nextInt(1000);
		
		Employee e = new Employee(id, empName, salary, department);
		try {
			boolean status = service.addEmployee(e);

			if(status)
			{
				System.out.println("INFO :- Employee Added "+e.getEmpId());
			}
			else
			{
				System.err.println("WARNING :- Contact to customer care , employee not added");
			}
		} catch (Exception e2) {
			System.err.println("WARNING :- Contact to customer care , employee not added");
			System.out.println(e2);
		}
		
		
		
	} // end insert employee
	
	
	
	public void getEmployeeById()
	{
		System.out.println("Enter the Employee Id to be Searched :- ");
		int searchId = sc.nextInt();
		try {
			Employee e = service.getEmployeeById(searchId);
			
			if(e != null) printEmployee(e);
			else throw new Exception("Employee "+searchId+" Not Found ");
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
	private void printEmployee(Employee e)
	{
		System.out.println(e);
		
		
	}
	
	
}//end of class























