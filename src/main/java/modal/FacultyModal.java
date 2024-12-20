package modal;

public class FacultyModal {

	private int id;
	private String firstname;
	private String lastname;
	private String gender;
	private Long mobile;
	private String mail;
	private int year;
	private String course;
	private String username;
	private String password;
	
	
	public FacultyModal() {
		
	}
	public FacultyModal(int id,String firstname, String lastname, String gender, Long mobile, String mail, int year,
			String course) {
		super();
		this.id=id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.mobile = mobile;
		this.mail = mail;
		this.year = year;
		this.course = course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	

}
