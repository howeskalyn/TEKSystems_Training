package com.test.project.classicmodelsDemo;

import java.util.List;

import com.test.controller.CustomerDAO;
import com.test.controller.EmployeeDAO;
import com.test.model.Customer;
import com.test.model.Employee;

public class App {
	public static void main(String[] args) {
		
		/*
		// Find the single order from orders table using primary key, orderNumber.
		OrderDAO orderDAO = new OrderDAO();
		Order o = orderDAO.findOrderByOrderNumber(10100);
		System.out.println(o.toString());

		// Set fields in orders table using primary key, orderNumber, like above.
		o.setStatus("PENDING");
		o.setShippedDate(new Date());
		orderDAO.update(o);
		
		// Find a list of orders where the status matches the input.
		List<Order> stats = orderDAO.findOrderByStatus("Cancelled");
		for (Order current : stats) {
			System.out.println(current);
		}
		
		Order newOrder = new Order();
		 newOrder.setOrderNumber(1111100); // wont run now because the row already exists !
		// newOrder.setOrderNumber(10100); // purposeful failure
		newOrder.setOrderDate(new Date());
		newOrder.setRequiredDate(new Date());
		newOrder.setShippedDate(new Date());
		newOrder.setStatus("WHATEVER");
		newOrder.setComments("Some comments about the order.");
		newOrder.setCustomerNumber(103); // need to ensure this number is actually in the customer table
		*/
		// orderDAO.insert(newOrder);
		
//		// Find the list of orders from orderdetails table using primary key, orderNumber.
//		OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
//		List<OrderDetail> ods = orderDetailDAO.findOrderDetailByOrderNumber(10100);
//		for (OrderDetail current : ods) {
//			System.out.println(current.toString());
//		}
		
		// Customer query with employee object returned
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = customerDAO.findByCustomerId(114);
		
		System.out.println("Customer Number = " + customer.getId());
		Employee salesRep = customer.getSalesRep();
		System.out.println("Employee (sales rep) First Name = " + salesRep.getFirstName());
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Employee e = employeeDAO.findByEmployeeId(1165);
		System.out.println("Employee Number = " + e.getEmployeeNumber() + " First Name = " + e.getFirstName());
		
		for( Customer c : e.getCustomers() ) {
			System.out.println("c.customerNumber = " + c.getId() + 
					" | First Name = " + c.getFirstName() + 
					" | Last name = " + c.getLastName() + 
					" Sales rep  | " + c.getSalesRep().getFirstName() );
		}
		
		Employee emp = employeeDAO.findByCustomerNumber(112);
		System.out.println(emp.getEmployeeNumber());
		
		
		
	}
}
