package com.JNIT.springapp.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.JNIT.springapp.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// we need the injection session factory

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	// @Transactional // we are removing this as we are implemeting it in
	// Customer service
	public List<Customer> getCustomer() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create the query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute the Query and get the list
		List<Customer> customers = theQuery.getResultList();

		// return the result

		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// save the customer
		// currentSession.save(theCustomer);

		// Save or update
		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomerDetails(int theId) {

		// get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve / load the customer deatils wiht the primary key

		Customer theCustomer = currentSession.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public void deleteCustomerDetails(int theId) {
		// get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
		

	}

}
