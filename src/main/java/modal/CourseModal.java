package modal;

public class CourseModal {

	private int courseid;
	private String coursename;
	private int fee;
	private int duration;
	private String location;

	



	public CourseModal(int courseid, String coursename, int fee, int duration, String location) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.fee = fee;
		this.duration = duration;
		this.location = location;
	}
	


	public CourseModal() {
		// TODO Auto-generated constructor stub
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}