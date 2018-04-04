package by.htp.library.dao.impl;

import java.util.ArrayList;
import java.util.List;

import static by.htp.library.dao.impl.util.DBConnectionHelper.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp.library.bean.Book;
import by.htp.library.bean.Employee;
import by.htp.library.bean.Entity;
import by.htp.library.dao.BookDao;
import by.htp.library.dao.EmployeeDao;

public class EmployeeDaoDBImpl implements EmployeeDao{
	
	public static final String SQL_SELECT_EMPLOYEES = "select * from employee";

	public void create(Employee entity) {
		// TODO Auto-generated method stub

	}

	public Employee read(int id) {
		
		  Employee emp = new Employee();
		  Connection connection = connect();
			 
		  try {
		   Statement st=connection.createStatement();
		   ResultSet rs=st.executeQuery(formEmployeeByIdQuery(id)); 
		   rs.next();
		   emp.setId(rs.getInt("id"));
		   emp.setName(rs.getString("name"));
		   emp.setSurname(rs.getString("surname"));  
		   
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		  disconnect(connection);
		
		return emp;
	}
	
	public List<Employee> getBySurname(String surname) {
		
		  List<Employee> employees = new ArrayList<>();
		  Connection connection = connect();
		 
		  try {
		   Statement st=connection.createStatement();// ������� � ���� ������
		   ResultSet rs=st.executeQuery(formEmployeeBySurnameQuery(surname)); // ������ ���������� ��������� ������
		   
		 		  
		   while(rs.next()) {
			    Employee emp= new Employee();
			    emp.setId(rs.getInt("id"));//select*from book ������ �� ������ �������
			    emp.setName(rs.getString("name"));
			    emp.setSurname(rs.getString("surname"));
			    
			    employees.add(emp);
			   }
		   
		   
		   
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		  disconnect(connection);
		  
		  return employees;
	}
	
	public String formEmployeeBySurnameQuery(String surname) {
		String s = "select * from employee where employee.surname='"+surname+"'";
		return s;
	}
	
	public String formEmployeeByIdQuery(int id) {
		String s = "select * from employee where employee.id=" + id;
		return s;
	}

	public List<Employee> readAll() {
		
		  List<Employee> employees = new ArrayList<>();
		  Connection connection = connect();
		 
		  try {
		   Statement st=connection.createStatement();// ������� � ���� ������
		   ResultSet rs=st.executeQuery(SQL_SELECT_EMPLOYEES); // ������ ���������� ��������� ������
		   
		 		  
		   while(rs.next()) {
			    Employee emp= new Employee();
			    emp.setId(rs.getInt("id"));//select*from book ������ �� ������ �������
			    emp.setName(rs.getString("name"));
			    emp.setSurname(rs.getString("surname"));
			    
			    employees.add(emp);
			   }
		   
		   
		   
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		  disconnect(connection);
		  
		  return employees;
	 }

	public void update(Employee entity) {
		// TODO Auto-generated method stub

	}

	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	public void create(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	public void update(Entity entity) {
		// TODO Auto-generated method stub
		
	}

}