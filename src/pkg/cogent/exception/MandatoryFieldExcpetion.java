package pkg.cogent.exception;

public class MandatoryFieldExcpetion extends RuntimeException{
	private String errorMessage;
	public MandatoryFieldExcpetion(String errorMessage) {
	super(errorMessage);
	this.errorMessage=errorMessage;
	}

}
