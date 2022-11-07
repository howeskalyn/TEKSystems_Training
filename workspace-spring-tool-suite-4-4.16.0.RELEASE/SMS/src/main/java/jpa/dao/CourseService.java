package jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Course;

public class CourseService {

	// takes no parameter and returns every Course in the table
	public List<Course> getAllCourses() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "FROM Course c";
		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		List<Course> result = query.getResultList();

		// close resources
		tx.commit();
		factory.close();
		session.close();

		return result;
	}
}
