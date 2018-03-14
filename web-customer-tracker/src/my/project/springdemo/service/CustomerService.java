package my.project.springdemo.service;

import java.util.List;

import my.project.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);
}
