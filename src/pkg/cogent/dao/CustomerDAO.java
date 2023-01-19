package pkg.cogent.dao;

public interface CustomerDAO {
	public void create();

	public void read();

	public void update(String customerId);

	public void delete(String customerId);
	
	public void findCustomerById(String cID);
	public void findYongestCustomer(); 

}
