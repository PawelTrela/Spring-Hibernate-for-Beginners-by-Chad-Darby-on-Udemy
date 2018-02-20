package my.project.springdemo.dao;

import java.util.List;
import my.project.springdemo.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();
}
