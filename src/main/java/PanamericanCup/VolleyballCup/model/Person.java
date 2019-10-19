/**
 * 
 */
package PanamericanCup.VolleyballCup.model;

/**
 * @author ASUS
 *
 */
public class Person {
	
	private String id;
	private String first_name;
	private String last_name;
	private String email;
	private String gender;
	private String country;
	private String photo;
	private String date;

	public Person(String id, String first_name, String last_name, String email, String gender, String country,
			String photo, String date) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.photo = photo;
		this.date = date;
	}
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	

	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}

}
