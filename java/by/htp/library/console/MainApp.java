package by.htp.library.console;

import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.bean.Employee;
import by.htp.library.dao.BookDao;
import by.htp.library.dao.EmployeeDao;
import by.htp.library.dao.impl.BookDaoDBImpl;
import by.htp.library.dao.impl.EmployeeDaoDBImpl;

public class MainApp {

	public static void main(String[] args) {

		BookDao bDao = new BookDaoDBImpl();
		System.out.println("List of books -->");
		List<Book> books = bDao.readAll();
		for (Book book : books) {
			System.out.println("["+book.getTitle()+"; "+ book.getDescription()+"]");	
		}
		
		System.out.println();
		System.out.println("List of employees -->");
		
		EmployeeDao eDao = new EmployeeDaoDBImpl();
		List<Employee> employees = eDao.readAll();
		for (Employee employee: employees) {
			System.out.println("["+employee.getName()+"; "+employee.getSurname()+"]");
		}
		
		System.out.println();
		System.out.println("Book with ID=1 -->");
		
		Book bookId = (Book) bDao.read(1);
		System.out.println("["+bookId.getTitle()+"; "+ bookId.getDescription()+"]");
		
		System.out.println();
		System.out.println("Employee with ID=2 -->");
		
		Employee employee = (Employee) eDao.read(2);
		System.out.println("["+employee.getName()+"; "+employee.getSurname()+"]");
		
		String keySurname = "sn2";
		System.out.println();
		System.out.println("Employee with surname " + keySurname + "-->");
		
		List<Employee> emps = eDao.getBySurname(keySurname);
		for (Employee emp: emps) {
			System.out.println("["+emp.getName()+"; "+emp.getSurname()+"]");
		}

	}

}
