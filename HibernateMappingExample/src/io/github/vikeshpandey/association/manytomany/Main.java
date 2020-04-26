package io.github.vikeshpandey.association.manytomany;

import java.util.ArrayList;
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
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("manytomany/hibernate.cfg.xml")
				.build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();

		// creating session object
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();

		Answer an1 = new Answer();
		an1.setAnswername("Java is a programming language");
		an1.setPostedBy("user 1");

		Answer an2 = new Answer();
		an2.setAnswername("Java is a platform");
		an2.setPostedBy("user 2");

		Question q1 = new Question();
		q1.setQname("What is Java?");

		ArrayList<Answer> l1 = new ArrayList<Answer>();
		l1.add(an1);
		l1.add(an2);
		q1.setAnswers(l1);
		
//		Question q3 = new Question();
//		q3.setQname("What is a programming language?");
//		q3.setAnswers(l1);
		
		
		

		Answer ans3 = new Answer();
		ans3.setAnswername("Servlet is an Interface");
		ans3.setPostedBy("user 3");

		Answer ans4 = new Answer();
		ans4.setAnswername("Servlet is an API");
		ans4.setPostedBy("user 4");

		Question q2 = new Question();
		q2.setQname("What is Servlet?");
		ArrayList<Answer> l2 = new ArrayList<Answer>();
		l2.add(ans3);
		l2.add(ans4);
		q2.setAnswers(l2);

		session.persist(q1);
		session.persist(q2);

		t.commit();

		session.close();
		System.out.println("success");

		session = factory.openSession();
		TypedQuery query = session.createQuery("from Question");
		List<Question> list = query.getResultList();
		list.forEach(q -> {
			System.out.println("Question Name: " + q.getQname());
			q.getAnswers().forEach(a -> {
				System.out.println(a.getAnswername() + ":" + a.getPostedBy());
			});
		});

	}
}