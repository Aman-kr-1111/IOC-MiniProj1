package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nt.dao.ICustomerDAO;
import com.nt.model.Customer;

@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	@Autowired
	@Qualifier("db")
	private ICustomerDAO custDAO;

	@Override
	public String registerCustomer(Customer customer) throws Exception {
		// calculate discount, final amount
		double discountAmount = (customer.getBillAmount() * (customer.getDiscount() / 100.0));
		double finalAmount = customer.getBillAmount() - discountAmount;
		// set finalamount to Model class object
		customer.setFinalAmount(finalAmount);

		// use DAO
		int count = custDAO.insert(customer);

		return count == 0 ? "Customer registration failed"
				: "Customer Registered having BillAmount::" + customer.getBillAmount() + " Discount Amount::"
						+ discountAmount + " final Amount::" + finalAmount;
	}

}
