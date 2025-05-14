package Contact;

public class Contact {
	private int id;
	private String name;
	private String phoneNumber;
	private String email;
	
	public Contact(int id, String name, String phoneNumber, String email) {
		this.id = id;
		this.setName(name);
		this.setPhoneNumber(phoneNumber);
		this.setEmail(email);
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "ID: " + id + " Name:" + name + " PhoneNumber: " + phoneNumber + " Email: "  + email;
	}
	

}
