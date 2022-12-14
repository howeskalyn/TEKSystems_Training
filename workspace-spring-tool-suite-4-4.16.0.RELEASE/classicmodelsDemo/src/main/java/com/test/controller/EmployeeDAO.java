package com.test.controller;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.model.Employee;

public class EmployeeDAO {

	public Employee findByEmployeeId(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "FROM Employee e where e.id =: empId";
		TypedQuery<Employee> query = session.createQuery(hql, Employee.class);
		query.setParameter("empId", id);

		Employee result = query.getSingleResult();

		tx.commit();
		factory.close();
		session.close();

		return result;
	}

	public Employee findByCustomerNumber(Integer customerNumber) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "select e from Employee e, Customer c "
				+ "where e.employeeNumber = c.salesRep.employeeNumber"
				+ " and c.id = :custNum";
		TypedQuery<Employee> query = session.createQuery(hql, Employee.class);
		query.setParameter("custNum", customerNumber);

		Employee result = query.getSingleResult();

		tx.commit();
		factory.close();
		session.close();

		return result;

	}

}
