package io.github.vikeshpandey;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class UpdateExample {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();

		// creating session object
		Session session = factory.openSession();

		// update demo
		update(session);
	}

	private static void update(final Session session) {
		Transaction t = session.beginTransaction();
		Query<Employee> q = session.createQuery("update Employee set firstName=:n where id=:i");
		q.setParameter("n", "Simpli learn");
		q.setParameter("i", 1);

		int status = q.executeUpdate();
		t.commit();
		System.out.println("number of rows affected: " + status);
	}

}
