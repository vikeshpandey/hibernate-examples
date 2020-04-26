package io.github.vikeshpandey.inheritance.singletableperhierarchy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

class Main {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("singletableperhierarchy/hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();

		// creating session object
		Session session=factory.openSession(); 
		
		Transaction t=session.beginTransaction();
				
		Employee e1=new Employee();    
        e1.setName("first employee");    
            
        RegularEmployee e2=new RegularEmployee();    
        e2.setName("regular employee");    
        e2.setSalary(50000);    
        e2.setBonus(5);    
            
        ContractEmployee e3=new ContractEmployee();    
        e3.setName("contract employee");    
        e3.setPayPerHour(1000);    
        e3.setContractDuration("15 hours");    
            
        session.persist(e1);    
        session.persist(e2);    
        session.persist(e3);    
            
        t.commit();    
        session.close();    
        System.out.println("success");  

	}

}
