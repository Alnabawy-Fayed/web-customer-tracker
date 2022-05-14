package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import javax.annotation.PostConstruct;

import com.spring.dao.CustomerDao;
import com.spring.entity.Customer;
import com.spring.servic.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
 	@RequestMapping("/list")
	public String listCustomers(Model model) {
 		List<Customer> theCustomers = customerService.getCustomers();
 		model.addAttribute("customers", theCustomers);
		return "list-customers";
	}
 	@GetMapping("/showFormForAdd")
 	public String showFormForAdd(Model model) {
 		Customer theCustomer = new Customer();
 		model.addAttribute("customer",theCustomer);
 		return "customer-form";
 	}
 	@PostMapping("/saveCustomer")
 	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
 		customerService.save(theCustomer);
 		return "redirect:/customer/list";
 	}
 	@RequestMapping("/showFormForUpudate")
	public String showFormForUpdate(@RequestParam("customerId") int id,Model model) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute(customer);
		return "customer-form";
	}
 	@GetMapping("/delete")
 	public String delete(@RequestParam("customerId") int id) {
 		customerService.delete(id);
 		return "redirect:/customer/list";
 	}

}
