package pkg.cogent.controller;

import java.util.Scanner;

import pkg.cogent.service.CustomerService;

public class CustomerController {

	CustomerService cs;
	Scanner sc = new Scanner(System.in);
	String cid;

	public CustomerController() {
		cs = new CustomerService();
	}

	public void accpept(int choice) {
		switch (choice) {
		case 1:
			cs.save();
			break;
		case 2:
			cs.fetch();
			break;
		case 3:
			System.out.println("Please enter the customer ID");
			cid = sc.next();
			cs.modify(cid);
			break;
		case 4:
			System.out.println("Please enter the customer ID");
			cid = sc.next();
			cs.delete(cid);
			break;
		case 5:
			cs.findYougest();
			break;
		case 6:
			System.out.println("Please enter the customer ID");
			cid = sc.next();
			cs.findById(cid);;
		case 7:
			System.exit(choice);
			break;
		}
	}

}
