/**
 * 
 */
package pkg.cogent.exception;

/**
 * @author: Boqiang Cui
 * @date: Jan 18, 2023
 */
public class NoSuchCustomerException extends RuntimeException {
	
	public NoSuchCustomerException(String cId) {
		super(cId);
	}
}
