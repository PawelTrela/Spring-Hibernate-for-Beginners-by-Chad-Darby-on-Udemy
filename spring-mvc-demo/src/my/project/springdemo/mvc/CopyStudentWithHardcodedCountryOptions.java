package my.project.springdemo.mvc;

import java.util.LinkedHashMap;

public class CopyStudentWithHardcodedCountryOptions {
	private String firstName;
	private String lastName;
	private String country;
	private LinkedHashMap<String, String> countryOptions;
	
	public CopyStudentWithHardcodedCountryOptions() {
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("POL", "Poland");
		countryOptions.put("GER", "Germany");
		countryOptions.put("FRA", "France");
		countryOptions.put("UKR", "Ukraine");
		countryOptions.put("CZE", "Czechia");
		countryOptions.put("USA", "United States of America");
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
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
		this.countryOptions = countryOptions;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
		
	}
}
