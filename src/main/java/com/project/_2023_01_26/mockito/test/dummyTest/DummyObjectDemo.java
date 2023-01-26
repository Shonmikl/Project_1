package com.project._2023_01_26.mockito.test.dummyTest;

import com.project._2023_01_26.mockito.code.dummy.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DummyObjectDemo {

	/*
	 * Scenario 1. Standard use case
	 */
	public Customer createDummyCustomer() {
		State state = new State("CA");
		City city = new City("Los Angeles", state);
		Address address = new Address("Mulholland Drive", city);
		return new Customer("Jack", "Nicholson", address);
	}

	@Test
	public void addCustomerTest() {
		Customer dummy = createDummyCustomer();
		AddressBook addressBook = new AddressBook();
		addressBook.addCustomer(dummy);
		Assertions.assertEquals(1, addressBook.getNumberOfCustomers());
	}

	/*
	 * Scenario 2. Must deal with an exception on null dummy
	 */
	@Test
	public void addNullCustomerTest() {
		Customer dummy = null;
		AddressBook addressBook = new AddressBook();
		Assertions.assertThrows(NullPointerException.class,
				() -> addressBook.addCustomer(dummy));
	}

	/*
	 * Scenario 3. Avoid exceptions altogether by injecting a mock object
	 */
	@Test
	public void addCustomerWithDummyTest() {
		Customer dummy = Mockito.mock(Customer.class);
		AddressBook addressBook = new AddressBook();
		addressBook.addCustomer(dummy);
		Assertions.assertEquals(1, addressBook.getNumberOfCustomers());
	}
}