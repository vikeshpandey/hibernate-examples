package io.github.vikeshpandey;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class CriteriaExample {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();

		// creating session object
		Session session = factory.openSession();
		// creating transaction object
		Transaction t = session.beginTransaction();

		// select demo
		// Create CriteriaBuilder
		CriteriaBuilder builder = session.getCriteriaBuilder();

		// Create CriteriaQuery
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> employee = criteria.from(Employee.class);

		//criteria.select(employee).where(builder.ge(employee.get("id"), 3));

		// To get employees having id less than 115
		//criteria.select(employee).where(builder.lt(employee.get("id"), 4));

		// To get employees having firstname starting with test
		 criteria.select(employee).where(builder.like(employee.get("firstName"), "test%"));

		Query<Employee> query = session.createQuery(criteria);
		List<Employee> results = query.getResultList();
		results.forEach(emp -> System.out.println(emp.getFirstName()));

		session.close();
		factory.close();
	}
}
