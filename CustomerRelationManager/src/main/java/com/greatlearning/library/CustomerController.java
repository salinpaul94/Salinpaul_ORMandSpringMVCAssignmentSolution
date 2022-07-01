package com.greatlearning.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.library.model.Customer;
import com.greatlearning.library.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customers")
	public String getCustomer(Model model) {
		//get data form DB
		List<Customer> customers = customerService.findCustomer();
		customers.forEach(System.out::print);
		
		//send the value to view
		model.addAttribute("Customers", customers);
		return "customers";
	}
	
	@RequestMapping(value="/AddCustomer")
	public String displayCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("Customer", customer);
		return "NewCustomer";
	}
	
	@PostMapping(value = "/save")
	public String saveCustomer(@RequestParam int id,
			@RequestParam String firstName,
			@RequestParam String lastName,
			@RequestParam String email) {
		
		if(id != 0) {
			Customer customer = new Customer();
			customer.setId(id);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
			
			customerService.saveCustomer(customer);
		}
		
		return "redirect:/customers";
	}
	
	@RequestMapping("/delete")
	public String deleteBook(@RequestParam int id) {
		customerService.deleteById(id);
		
		return "redirect:/customers";
	}
	
	@RequestMapping("/search")
	public String searchCustomer(@RequestParam String name, Model model)
	{
		List<Customer> customers = customerService.findBy(name);
		
		model.addAttribute("Customers", customers);
		return "customers";
	}
	
	@RequestMapping("/Update")
	public String updateCustomer(@RequestParam int id, Model model)
	{
		// get data from DB
		Customer customer = customerService.findById(id);
		// send the value to view
		model.addAttribute("Customer", customer);
		return "UpdateCustomer";
	}
	
	@RequestMapping("/updateCustomer")
	public String updateCustomer(@RequestParam int id,
			@RequestParam String firstName,
			@RequestParam String lastName,
			@RequestParam String email,
			Model model)
	{
		customerService.updateCustomer(id, firstName, lastName, email);
		
		return "redirect:/customers";
	}
}
