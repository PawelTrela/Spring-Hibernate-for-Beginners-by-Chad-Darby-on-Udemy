package my.project.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import my.project.springdemo.mvc.validation.CourseCode;

public class Customer {
	private String firstName;
	@NotNull(message="is required")
	@Length(min=1, message="is required")
	private String lastName;
	
	@NotNull(message="is required")
	@Min(value=0, message="must be greater than or equal to 0")
	@Max(value=10, message="must be less than or equal o 10")
	private Integer freePasses;
	//@CourseCode // default values, given in interface (value="PT", message="must start with PT")
	@CourseCode(value="CC", message="must start with CC")
	private String courseCode;
	
	@Pattern(regexp="^\\d{2}-\\d{3}$", message="postal code must be dd-ddd")
	private String postalCode;
	
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
	public Integer getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
}
