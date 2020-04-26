package io.github.vikeshpandey;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDAO {

	void saveEmployee(SessionFactory factory) {
		Session session = factory.openSession();
		Transaction t = null;

		try {
			
			t = session.beginTransaction();
			// Create
			Employee e1 = new Employee();
			e1.setFirstName("john");
			e1.setLastName("doe");

			session.save(e1);
			t.commit();
			System.out.println("successfully saved");
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	void getEmployee(SessionFactory factory, int id) {
		Session session = factory.openSession();
		try {
			Employee employee = session.get(Employee.class, id);
			System.out.print("Id: " + employee.getId());
			System.out.print(" First Name: " + employee.getFirstName());
			System.out.println(" Last Name: " + employee.getLastName());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	void updateEmployee(SessionFactory factory, int id) {
		Session session = factory.openSession();
		Transaction t = null;

		try {
			t = session.beginTransaction();
			// Update
			Employee employee = session.get(Employee.class, id);
			employee.setFirstName("new name");
			session.update(employee);
			t.commit();
			System.out.println("successfully updated");
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	void deleteEmployee(SessionFactory factory, int id) {
		Session session = factory.openSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			// Delete
			Employee employee = session.get(Employee.class, id);
			session.delete(employee);
			t.commit();
			System.out.println("successfully deleted");
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	void getAllEmployees(SessionFactory factory) {
		Session session = factory.openSession();
		try {
			List<Employee> employees = session.createQuery("FROM Employee", Employee.class).list();
			for (Employee employee : employees) {
				System.out.print("Id: " + employee.getId());
				System.out.print(" First Name: " + employee.getFirstName());
				System.out.println(" Last Name: " + employee.getLastName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
