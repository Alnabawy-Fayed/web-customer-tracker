package com.spring.servic;

import java.util.List;

import com.spring.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void save(Customer theCustomer);

	public Customer getCustomer(int id);

	public void delete(int id);

}
