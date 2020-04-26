package io.github.vikeshpandey.mapping.component;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

class Main {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("mappingcomponent/hibernate.cfg.xml")
				.build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();

		// creating session object
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();

		Employee e1 = new Employee();
		e1.setName("test user");
		e1.setEmail("test@gmail.com");

		Address address1 = new Address();
		address1.setAddressLine1("urban street");
		address1.setCity("stockholm");
		address1.setState("stockholm county");
		address1.setCountry("sweden");
		address1.setPincode(11111);

		e1.setAddress(address1);

		session.persist(e1);
		t.commit();

		session.close();
		System.out.println("success");

		session = factory.openSession();
		TypedQuery query = session.createQuery("from Employee");
		List<Employee> list = query.getResultList();

		list.forEach(emp -> {
			System.out.println(emp.getEmployeeId() + " " + emp.getName() + " " + emp.getEmail());
			Address address = emp.getAddress();
			System.out.println(address.getAddressLine1() + " " + address.getCity() + " " + address.getState() + " "
					+ address.getCountry() + " " + address.getPincode());
		});

	}
}
