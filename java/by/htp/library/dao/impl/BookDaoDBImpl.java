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
import by.htp.library.bean.Entity;
import by.htp.library.dao.BookDao;

public class BookDaoDBImpl implements BookDao{
	
	public static final String SQL_SELECT_BOOKS = "select * from book";

	public void create(Book entity) {
		// TODO Auto-generated method stub

	}

	public Book read(int id) {
		
		  Book book = new Book();
		  Connection connection = connect();
			 
		  try {
		   Statement st=connection.createStatement();
		   ResultSet rs=st.executeQuery(formBookByIdQuery(id)); 
		   rs.next();
		   book.setId(rs.getInt("id"));
		   book.setTitle(rs.getString("title"));
		   book.setDescription(rs.getString("description"));  
		   
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		  disconnect(connection);
		
		return book;
	}
	
	public String formBookByIdQuery(int id) {
		String s = "select * from book where book.id=" + id;
		return s;
	}

	public List<Book> readAll() {
		
		  List<Book> books = new ArrayList<>();
		  Connection connection = connect();
		 
		  try {
		   Statement st=connection.createStatement();// ������� � ���� ������
		   ResultSet rs=st.executeQuery(SQL_SELECT_BOOKS); // ������ ���������� ��������� ������
		   
		 		  
		   while(rs.next()) {
			    Book book= new Book();
			    book.setId(rs.getInt("id"));//select*from book ������ �� ������ �������
			    book.setTitle(rs.getString("title"));
			    book.setDescription(rs.getString("description"));
			    
			    books.add(book);
			   }
		   
		   
		   
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		  disconnect(connection);
		  
		  return books;
	 }

	public void update(Book entity) {
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