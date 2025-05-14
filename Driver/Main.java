package Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Contact.Contact;
import ContactManager.ContactManager;

public class Main {
	public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        List<Contact> contacts = new ArrayList();;
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
                	try {
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter phone number: ");
                        String phone = sc.nextLine();
                        System.out.print("Enter email: ");
                        String email = sc.nextLine();
                        manager.addContact(name, phone, email);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Failed to add contact: " + e.getMessage());
                    }
                    break;

                    
                case 2:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    manager.searchByName(searchName);
                    break;
                    
                case 3:
                    System.out.print("Enter phone number to search: ");
                    String searchPhone = sc.nextLine();
                    manager.searchByNumber(searchPhone);
                    break;
                    
                case 4:
                    System.out.print("Enter contact ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();
                    manager.deleteById(deleteId);
                    break;
                    
                case 5:
                	try {
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
                    
                    System.out.println("Enter new name: ");
                    String updatedName = sc.nextLine();
                    System.out.println("Enter new phone number: ");
                    String updatedPhone = sc.nextLine();
                    System.out.println("Enter new email: ");
                    String updatedEmail = sc.nextLine();
                    
                    manager.updateContact(updateId, updatedName, updatedPhone, updatedEmail);
                    } catch (IllegalArgumentException e) {
                             System.out.println("Failed to update contact: " + e.getMessage());
                    }
                    break;
                    
                case 6:
                    manager.displayAllContacts();
                    break;
                    
                case 7:
                    System.out.println("Ending Operations");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice. Please try between 1-6.");
                
            }
        }
    }

}