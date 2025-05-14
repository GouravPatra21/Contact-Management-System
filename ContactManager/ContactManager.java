package ContactManager;
import java.util.ArrayList;
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
                System.out.println("Contact is  deleted successfully: " + removedContact);
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

    public void showOperations() {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("Operations of Contact Mangement System");
            System.out.println("1. Add Contact");
            System.out.println("2. Search by Name");
            System.out.println("3. Search by Phone Number");
            System.out.println("4. Delete Contact");
            System.out.println("5. Update Contact");
            System.out.println("6. View All Contacts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); 
            
            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    addContact(name, phone, email);
                    break;
                    
                case 2:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    searchByName(searchName);
                    break;
                    
                case 3:
                    System.out.print("Enter phone number to search: ");
                    String searchPhone = sc.nextLine();
                    searchByNumber(searchPhone);
                    break;
                    
                case 4:
                    System.out.print("Enter contact ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();
                    deleteById(deleteId);
                    break;
                    
                case 5:
                    System.out.print("Enter contact ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine(); 
                    System.out.println("Current Contact Details: ");
           
                    Contact contactToUpdate = null;
                    for (Contact contact : contacts) {
                        if (contact.getId() == updateId) {
                            contactToUpdate = contact;
                            break;
                        }
                    }
                    System.out.print(contactToUpdate);
                    if (contactToUpdate == null) {
                        System.out.println("No contact found with ID: " + updateId);
                        break;
                    }
                    
                    System.out.print("Enter new name: ");
                    String updatedName = sc.nextLine();
                    System.out.print("Enter new phone number: ");
                    String updatedPhone = sc.nextLine();
                    System.out.print("Enter new email: ");
                    String updatedEmail = sc.nextLine();
                    
                    updateContact(updateId, updatedName, updatedPhone, updatedEmail);
                    break;
                    
                case 6:
                    displayAllContacts();
                    break;
                    
                case 7:
                    System.out.println("Ending Operations");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        ContactManager cmanager = new ContactManager();
        cmanager.showOperations();
    }
}