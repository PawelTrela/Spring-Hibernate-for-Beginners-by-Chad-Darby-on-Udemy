package my.project.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.project.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//inject the session factory
	@Autowired
	private SessionFactory sessionFactory; // field name must be equal to bean id specified in file spring-mvc-crud-demo-servlet.xml
	
	@Override
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query
		Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);
		// execute query and get result list
		List<Customer> customers = query.getResultList();
		// return the results
		return customers;
	}

}
