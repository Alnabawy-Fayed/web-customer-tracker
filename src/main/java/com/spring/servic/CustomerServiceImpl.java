package com.spring.servic;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dao.CustomerDao;
import com.spring.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerDao customerDao;
         
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public void save(Customer theCustomer) {
		customerDao.save(theCustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		Customer customer = customerDao.getCustomer(id);
		return customer;
	}

	@Override
	@Transactional
	public void delete(int id) {
		customerDao.delete(id);
		
	}
	

}
