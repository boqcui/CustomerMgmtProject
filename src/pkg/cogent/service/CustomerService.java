package pkg.cogent.service;

import pkg.cogent.dao.CustomerDAOImpl;
import pkg.cogent.exception.MandatoryFieldExcpetion;
import pkg.cogent.exception.NoSuchCustomerException;

public class CustomerService {
	CustomerDAOImpl dao;
	public CustomerService() {
		dao = new CustomerDAOImpl();
	}

	public void save() {
		try {
			dao.create();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fetch() {
		dao.read();
	}

	public void modify(String cId) {
		try {
			dao.update(cId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void delete(String cId) {
		try {
			dao.delete(cId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void findYougest() {
		try{
			dao.findYongestCustomer();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void findById(String cId) {
		try{
			dao.findCustomerById(cId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
