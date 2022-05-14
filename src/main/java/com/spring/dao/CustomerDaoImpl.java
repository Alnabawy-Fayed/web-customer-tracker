package com.spring.dao;

import java.util.List;

import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.spring.entity.Customer;
@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers(){
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> myQuery = session.createQuery("from Customer",Customer.class);
		List<Customer> customers = myQuery.getResultList();
		return customers;
		
	}

	@Override
	public void save(Customer theCustomer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.get(Customer.class,id);
		return null;
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query theQuery = session.createQuery("delete from Customer where id =:customerId ");
		theQuery.setParameter("customerId", id);
		theQuery.executeUpdate();
		
	}

}
