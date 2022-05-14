package com.spring.dao;

import java.util.List;

import com.spring.entity.Customer;

public interface CustomerDao {
	public List<Customer> getCustomers();

	public void save(Customer theCustomer);

	public Customer getCustomer(int id);

	public void delete(int id);

}
