package ContactManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Contact.Contact;

public class ContactManager {
    private List<Contact> contacts;
    private int nextId;

    public ContactManager() {
        contacts = new ArrayList<>();
        nextId = 1;
    }

    public void addContact(String name, String phoneNumber, String email) {
        Contact newContact = new Contact(nextId++, name, phoneNumber, email);
        contacts.add(newContact);
        System.out.println("Contact added successfully: " + newContact);
    }

    public void searchByName(String name) {
        System.out.println("Search Contact by Name: " + name);
        boolean found = false;
        String searchTerm = name.toLowerCase();
        
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(searchTerm)) {
                System.out.println(contact);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No contacts founnd with the same name" + name);
        }
    }

    public void searchByNumber(String phoneNumber) {
        System.out.println("Search Contact by Phone Number: " + phoneNumber);
        boolean found = false;
        
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().contains(phoneNumber)) {
                System.out.println(contact);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No contacts found with phone number: " + phoneNumber);
        }
    }

    public void deleteById(int id) {
        boolean flag = false;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId() == id) {
                Contact removedContact = contacts.remove(i);
//        Iterator<Contact> iterator = contacts.iterator();
//		while (iterator.hasNext()) {
//			if (iterator.next().getId() == id) {
//				iterator.remove();
        
                System.out.println("Contact is  deleted successfully: " + removedContact);
//				System.out.println("Contact is  deleted successfully");
                flag = true;
                break;
            }
        }
        
        if (flag == false) {
            System.out.println("No contact found with ID: " + id);
        }
    }

    public void updateContact(int id, String newName, String newPhone, String newEmail) {
        Contact Update = null;
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                Update = contact;
                break;
            }
        }
        
        if (Update == null) {
            System.out.println("No contact found with ID: " + id);
            return;
        }
        System.out.println("Update it with new details");
        if (newName != null && !newName.isEmpty()) {
            Update.setName(newName);
        }
        if (newPhone != null && !newPhone.isEmpty()) {
            Update.setPhoneNumber(newPhone);
        }
        if (newEmail != null && !newEmail.isEmpty()) {
            Update.setEmail(newEmail);
        }
        
        System.out.println("Contact is updated successfully: " + Update);
    }

    public void displayAllContacts() {
        System.out.println("All the Contacts in the list are:");
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
}

    