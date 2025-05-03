package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Customer;
import com.nt.service.ICustomerMgmtService;

//@Controller("custController")
@Controller
public class CustomerOperationController {
	@Autowired
	private ICustomerMgmtService custService;

	public String processCustomer(Customer customer) throws Exception {
		// use service
		String result = custService.registerCustomer(customer);
		return result;
	}
}
