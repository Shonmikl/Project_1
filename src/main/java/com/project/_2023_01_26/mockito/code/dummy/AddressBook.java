package com.project._2023_01_26.mockito.code.dummy;


import java.util.ArrayList;
import java.util.List;

public class AddressBook {

	public List<Customer> customers = new ArrayList<>();
	public void addCustomer(Customer customer) {
		if (customer == null) throw new NullPointerException();
		customers.add(customer);
	}
	public int getNumberOfCustomers() {
		return customers.size();
	}
}
