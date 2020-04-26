package io.github.vikeshpandey;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class DeleteExample {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();

		// creating session object
		Session session = factory.openSession();

		// update demo
		delete(session);
	}

	private static void delete(final Session session) {
		Transaction t = session.beginTransaction();
		Query<Employee> q = session.createQuery("delete from Employee where id=:i");
		q.setParameter("i", 1);

		int status = q.executeUpdate();
		t.commit();
		System.out.println("number of rows affected: " + status);
	}

}
