package Contact;

public class Contact {
	private int id;
	private String name;
	private String phoneNumber;
	private String email;

	public Contact(int id, String name, String phoneNumber, String email) {
		this.setId(id);
		this.setName(name);
		this.setPhoneNumber(phoneNumber);
		this.setEmail(email);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("ID must be a positive number.");
		}
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || !name.matches("[a-zA-Z ]+")) {
			throw new IllegalArgumentException("Name must contain only letters and spaces.");
		}
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber == null || !phoneNumber.matches("^[789]\\d{9}$")) {
			throw new IllegalArgumentException("Phone number must be 10 digits.");
		}
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        this.email = email;
    }
		   

	@Override
	public String toString() {
		return "ID: " + id + " Name: " + name + " PhoneNumber: " + phoneNumber + " Email: " + email;
	}
}
