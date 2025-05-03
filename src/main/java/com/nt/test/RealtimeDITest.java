package com.nt.test;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.CustomerOperationController;
import com.nt.model.Customer;

public class RealtimeDITest {

	public static void main(String[] args) {
		// read input values from endUser
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter customer name::");
		String name = sc.next();
		System.out.print("Enter customer address::");
		String addrs = sc.next();
		System.out.print("Enter customer bill amount::");
		double billAmt = sc.nextDouble();
		System.out.print("Enter discount percentage::");
		double discount = sc.nextDouble();

		// create customer class object
		Customer cust = new Customer();
		cust.setCname(name);
		cust.setCaddrs(addrs);
		cust.setBillAmount(billAmt);
		cust.setDiscount(discount);

		// create IOC container using try with resources
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/nt/cfgs/applicationContext.xml");) {

			// get controller class object from the IOC container(dependency lookup)

			// CustomerOperationController controller = ctx.getBean("custController",
			// CustomerOperationController.class);
			CustomerOperationController controller = ctx.getBean("customerOperationController",
					CustomerOperationController.class);

			// invoke the b.method
			String resultMsg = controller.processCustomer(cust);
			System.out.println(resultMsg);

		} catch (Exception e) {
			System.out.println("Internal Problem---Try again::" + e.getMessage());
			// e.printStackTrace();
		}

	}// main

}// class
