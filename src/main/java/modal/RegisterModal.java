package modal;

public class RegisterModal {

	private String firstname;

//	public RegisterModal(String firstname) {
//	
//		this.firstname = firstname;
//	}

	public RegisterModal() {}

	@Override
	public String toString() {
		return "Register11 [firstname=" + firstname + "]";
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
}

