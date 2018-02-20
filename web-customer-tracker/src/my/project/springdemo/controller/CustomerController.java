package my.project.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import my.project.springdemo.entity.Customer;
import my.project.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject the customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		// get customers from the DAO
		List<Customer> customers = customerService.getCustomers();
		
		// add customers to the model
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
}
