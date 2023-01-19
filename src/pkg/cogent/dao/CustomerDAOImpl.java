package pkg.cogent.dao;

import java.util.Scanner;

import pkg.cogent.exception.MandatoryFieldExcpetion;
import pkg.cogent.exception.NoCustomerExcpetion;
import pkg.cogent.exception.NoSuchCustomerException;
import pkg.cogent.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	Customer customers[];
	Scanner sc=new Scanner(System.in);
	@Override
	public void create() {
		
		System.out.println("How many customer you want to store?");
		int size=sc.nextInt();
		customers=new Customer[size];
		for(int i=0;i<customers.length;i++)
		{
			System.out.println("Please enter customer ID:");
			String cid=sc.next();		
			System.out.println("Please enter customer name:");
			String cname=sc.next();
			System.out.println("Please enter customer email:");
			String eMail=sc.next();
			System.out.println("Please enter customer brithday: (yyyy/mm/dd)");
			String cDob=sc.next();
			if (cDob.replaceAll("[^0-9]", "") == "") {
				throw new MandatoryFieldExcpetion("Not a vaild DOB.");
			}
			Customer cust=new Customer(cid, cname, eMail, Integer.parseInt(cDob.replaceAll("[^0-9]", "")));
			validateMandatoryField(cust);
			customers[i]=cust;
		}
	}
	
	public void validateMandatoryField(Customer customer)
	{
		if(customer==null)
		{
			throw new MandatoryFieldExcpetion("Customer object can not be left blank");
		}
		else if(customer.getcId()==null)
		{
			throw new MandatoryFieldExcpetion("Customer ID can not be left blank");
		}
		else if (findCus(customer.getcId()) != null) {
			throw new MandatoryFieldExcpetion("Customer ID can not be the same, please use unique cId");
		}
		else if (String.valueOf(customer.getcDob()).length() != 8) {
			throw new MandatoryFieldExcpetion("Customer birthday doesn't in the correct format");
		}
		
		// Check customer birthday
		int month = Integer.parseInt(String.valueOf(customer.getcDob()).substring(4,6));
		int day = Integer.parseInt(String.valueOf(customer.getcDob()).substring(6,8));
		if (month < 1 || month > 12) throw new MandatoryFieldExcpetion("DOB month didn't correct");
		if (day < 1 || day > 31) throw new MandatoryFieldExcpetion("DOB day didn't correct");
	}

	@Override
	public void read() {
		for(Customer c : customers) {
			if (c != null) showCustomerInfo(c);
		}
	}

	@Override
	public void update(String customerId) {
		checkEmpty();
		Customer c = findCus(customerId);
		if (c == null) {
			throw new NoSuchCustomerException(customerId);
		}
		System.out.println("Please enter customer's new name:");
		String cname=sc.next();
		System.out.println("Please enter customer's new email:");
		String eMail=sc.next();
		System.out.println("Please enter customer's new brithday: (yyyy/mm/dd)");
		String cDob=sc.next();
		if (cDob.replaceAll("[^0-9]", "") == "") {
			throw new MandatoryFieldExcpetion("Not a vaild DOB.");
		}
		
		c.setcDob(Integer.parseInt(cDob.replaceAll("[^0-9]", "")));
		c.setcEmail(eMail);
		c.setcName(cname);
		
	}

	@Override
	public void delete(String customerId) {
		checkEmpty();
		// TODO Auto-generated method stub
		for (int i = 0; i < customers.length; i++) {
			if (customers[i] != null && customers[i].getcId().equals(customerId)) {
				customers[i]=null;
				return;
			}
		}
		throw new NoSuchCustomerException(customerId);
	}
	
	@Override
	public void findCustomerById(String cID) {
		checkEmpty();
		Customer c = findCus(cID);
		if (c == null) {
			System.out.println("No customer has cId: " + cID);
		} else {
			showCustomerInfo(c);
		}
	}
	
	@Override
	public void findYongestCustomer() {
		checkEmpty();
		Customer yongest = null;
		for (Customer c: customers) {
			if (c == null) continue;
			if (yongest==null || yongest.getcDob() < c.getcDob()) {
				yongest = c;
			}
		}
		if (yongest == null) {
			System.out.println("There is not customer inside the database.");
		} else {
			showCustomerInfo(yongest);
		}
	}
	
	private void showCustomerInfo(Customer c) {
		System.out.println("Customer ID: "+c.getcId());
		System.out.println("Customer  name: "+c.getcName());
		System.out.println("Customer e-mail: "+c.getcEmail());
		String sDoc = String.valueOf(c.getcDob());
		System.out.println("Customer brithday: "+ (sDoc.substring(0, 4)+"/"+sDoc.substring(4, 6)+"/"+sDoc.substring(6, 8)));
	}
	
	private Customer findCus(String cID) {
		for (Customer c:customers) {
			if (c != null && c.getcId().equals(cID)) return c;
		}
		return null;
	}
	
	private void checkEmpty() {
		if (customers==null) {
			throw new NoCustomerExcpetion();
		}
	}

}
