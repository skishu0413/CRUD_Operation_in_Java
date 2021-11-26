package studentpage.model;

public class Student {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String majorClass;
	private String minorClass;
	private String semester;
	private String state;
	private String country;
	
	
	
	public Student(int id, String firstName, String lastName, String email, String majorClass, String minorClass,
			String semester, String state, String country) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.majorClass = majorClass;
		this.minorClass = minorClass;
		this.semester = semester;
		this.state = state;
		this.country = country;
	}
	
	
	
	
	public Student(String firstName, String lastName, String email, String majorClass, String minorClass,
			String semester, String state, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.majorClass = majorClass;
		this.minorClass = minorClass;
		this.semester = semester;
		this.state = state;
		this.country = country;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMajorClass() {
		return majorClass;
	}
	public void setMajorClass(String majorClass) {
		this.majorClass = majorClass;
	}
	
	public String getMinorClass() {
		return minorClass;
	}
	public void setMinorClass(String minorClass) {
		this.minorClass = minorClass;
	}
	
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
