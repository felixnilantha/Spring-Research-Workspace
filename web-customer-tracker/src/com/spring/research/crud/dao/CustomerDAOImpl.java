package com.spring.research.crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.research.crud.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// create a query

		List<Customer> listCustomers = theQuery.getResultList();

		// execute query and get result list

		return listCustomers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/update customer
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get customer
		Customer theCustomer = currentSession.get(Customer.class, theId);

		// return customer
		return theCustomer;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteCustomer(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get customer
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");

		// delete customer
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();

	}

}
