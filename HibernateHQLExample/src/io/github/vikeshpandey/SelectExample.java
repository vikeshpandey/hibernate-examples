package io.github.vikeshpandey;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SelectExample {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();

		// creating session object
		Session session = factory.openSession();

		// select demo
		//simpleSelectDemo(session);
		//simpleSelectWithAliasDemo(session);
		//aggregateFunctions(session);
		orderBy(session);
	}

	private static void simpleSelectDemo(Session session) {
		TypedQuery<Employee> query = session.createQuery("from Employee", Employee.class);// here persistent class name
																							// is Employee

		List<Employee> list = query.getResultList();
		System.out.println("simple Select demo");
		list.forEach(employee -> System.out.println("Employee name is: " + employee.getFirstName()));
		System.out.println("================================================");
	}

	private static void simpleSelectWithAliasDemo(Session session) {
		TypedQuery<Employee> query = session
				.createQuery("from Employee as emp where emp.firstName = :firstNameParam", Employee.class)
				.setParameter("firstNameParam", "test5");

		List<Employee> list = query.getResultList();
		System.out.println("Select alias demo");
		list.forEach(employee -> System.out.println("Employee name is: " + employee.getFirstName()));
	}
	
	private static void aggregateFunctions(Session session) {
	    Integer sum =  (Integer) session.createQuery("SELECT min(id) from Employee")
	    	      .getSingleResult();
	    System.out.println(sum);
	}
	
	private static void orderBy(Session session) {
	    List<Employee> list = session.createQuery("from Employee order by id desc", Employee.class)
	    	      .getResultList();
	    list.forEach(item -> System.out.println(item.getId()));
	}
}
