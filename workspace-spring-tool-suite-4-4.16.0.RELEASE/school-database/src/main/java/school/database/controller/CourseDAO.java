package school.database.controller;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import school.database.model.Course;
import java.util.List;

public class CourseDAO {

	public Course findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "FROM Course c where c.id =: courseId";
		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		query.setParameter("courseId", id);

		Course result = query.getSingleResult();

		// Close resources
		tx.commit();
		factory.close();
		session.close();

		return result;
	}

	public List<Course> findByCourseName(String name) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "select c from Course c where c.name = :name";
		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		query.setParameter("name", name);

		List<Course> result = query.getResultList();

		tx.commit();
		factory.close();
		session.close();

		return result;
	}

	public List<Course> findByCourseNameStartsWith(String name) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		String hql = "SELECT c FROM Course c where c.name = :name";

		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		query.setParameter("name", name + "%");

		List<Course> result = query.getResultList();

		t.commit();
		factory.close();
		session.close();

		return result;
	}

	public void insert(Course course) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		session.save(course);

		t.commit();
		factory.close();
		session.close();
	}

	public void update(Course order) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		session.merge(order);

		t.commit();
		factory.close();
		session.close();
	}

}
