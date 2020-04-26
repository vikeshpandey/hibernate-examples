package io.github.vikeshpandey;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SaveEmployee {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();

		// creating session object

		Employee e = new Employee();
		e.setFirstName("test6");
		e.setLastName("users6");
		Session session = factory.openSession();

		// creating transaction object
		Transaction t = session.beginTransaction();


		// persisting the object
		session.save(e);

		t.commit();// transaction is commited
		session.close();
		System.out.println("successfully saved");

	}

}
