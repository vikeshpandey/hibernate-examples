package io.github.vikeshpandey.mapping.collection;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

class Main {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("mappingcollection/hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();

		// creating session object
		Session session=factory.openSession(); 
		
		Transaction t=session.beginTransaction();
				
		College c=new College(1,"S.S.P.C");
    	session.persist(c);
    	
        Student s1=new Student(1,"user1",1);
        session.persist(s1);
        
        Student s2=new Student(2,"user2",1);
        session.persist(s2);
        
        t.commit();
        session.close();
        
        System.out.println("success");   

	}

}
