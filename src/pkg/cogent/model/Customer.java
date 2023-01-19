package pkg.cogent.model;

public class Customer {
	private String cId;
	private String cName;
	private String cEmail;
	private int cDob;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String cId, String cName, String cEmail, int cDob) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cEmail = cEmail;
		this.cDob = cDob;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public int getcDob() {
		return cDob;
	}

	public void setcDob(int cDob) {
		this.cDob = cDob;
	}

}
