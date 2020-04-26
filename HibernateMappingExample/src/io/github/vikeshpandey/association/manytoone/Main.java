package io.github.vikeshpandey.association.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

class Main {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("manytoone/hibernate.cfg.xml")
				.build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();

		// creating session object
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();

		Employee e1 = new Employee();
		e1.setName("test user");
		e1.setEmail("test@gmail.com");

		Employee e2 = new Employee();
		e2.setName("test user 2");
		e2.setEmail("test2@gmail.com");

		Address address1 = new Address();
		address1.setAddressLine1("urban street");
		address1.setCity("stockholm");
		address1.setState("stockholm county");
		address1.setCountry("sweden");
		address1.setPincode(11111);

		e1.setAddress(address1);
		e2.setAddress(address1);

		session.persist(e1);
		session.persist(e2);
		t.commit();    
        
	    session.close();    
	    System.out.println("success"); 
	}
}