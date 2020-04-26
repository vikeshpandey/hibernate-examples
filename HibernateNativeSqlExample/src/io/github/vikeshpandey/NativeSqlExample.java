package io.github.vikeshpandey;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;

public class NativeSqlExample {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();

		// creating session object
		Session session = factory.openSession();

		NativeQuery<Employee> query = session.createNativeQuery("select * from employee");
		query.addEntity(Employee.class);
		List<Employee> rows = query.getResultList();
		for (Employee row : rows) {
			System.out.println(row.getFirstName());
		}
		
		session.close();
		factory.close();
	}
}
