package com.collections;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
	public AddressBookMain() {
		this.person = person;
	}

	static Scanner sc = new Scanner(System.in);
	static ArrayList<PersonContact> person;
	MultipleAddressBook multipleAddressBook = new MultipleAddressBook();

	/**
	 * adding new contact in Book
	 */
	public void newcontact() {

		System.out.println("Enter First Name: ");
		String firstname = sc.nextLine();
		sc.nextLine();
		System.out.println("Enter last Name: ");
		String lastname = sc.nextLine();

		System.out.println("Enter your address: ");
		String address = sc.nextLine();

		System.out.println("Enter your City: ");
		String city = sc.nextLine();

		System.out.println("Enter your state: ");
		String state = sc.nextLine();

		System.out.println("Enter zip code : ");
		int zip = sc.nextInt();

		System.out.println("Enter phone number: ");
		String phoneno = sc.nextLine();
		sc.nextLine();
		System.out.println("Enter your EMail ID: ");
		String email = sc.nextLine();
		PersonContact pc = new PersonContact(firstname, lastname, address, city, state, zip, phoneno, email);

		System.out.println("The Contact Details of " + firstname + "\n" + pc);
	}

	public void duplicateCheck() {
		System.out.print(" Please enter the first name: ");
		String name = sc.next();
		for (PersonContact i : person) {
			if (i.getFirstName().equals(name)) {
				System.out.println(" Given name already exists");
			}
			return;
		}
		newcontact();
	}

	/**
	 * editperson - EDiting data of the Person
	 */
	public void editPerson() {
		System.out.println("Enter name to Modify Data");
		String editinput = sc.next();
		for (int i = 0; i < person.size(); i++) {// get contacts for whole array list
			PersonContact pc1 = (PersonContact) person.get(i);
			if (editinput.equals(pc1.getFirstName())) {
				newcontact();/// calling add person to replace
				for (int j = 0; j < person.size(); j++) {
					person.set(j, pc1);
				}

			} else {
				System.out.println("No matches found for given first name.");
			}
		}
	}

	/**
	 * deleteperson - modify data by deleting data of the Person
	 */
	public void deletePerson() {
		System.out.println("Enter name to Delete the Data");
		String s = sc.next();

		for (int i = 0; i < person.size(); i++) {
			PersonContact p = (PersonContact) person.get(i);
			if (s.equals(p.getFirstName())) {
				System.out.println(p);
				person.remove(i);
				System.out.println("Contact Deleted");
			} else {
				System.out.println("No matches found for given first name.");
			}
		}
	}

	public void addMultiplePerson() {
		while (true) {
			System.out.println("Enter the option \n" + "1)To Add New Address Book\n" + "2)To Add New Contact\n"
					+ "3)To Check Duplicate Contact" + "4)To Edit Contact" + "\n4)To Delete Contact"
					+ "\n5)To Print Address Books\n6)Exit");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				multipleAddressBook.addressBookAddition();
				break;
			case 2:
				multipleAddressBook.addingContacts();
				break;
			case 3:
				multipleAddressBook.duplicateContacts();
				break;
			case 4:
				multipleAddressBook.editingContacts();
				break;
			case 5:
				multipleAddressBook.deletingContacts();
				break;
			case 6:
				multipleAddressBook.printAddressBook();
				break;
			case 7: {
				System.out.println("You are out of the address book system");
			}

				break;
			default:
				System.out.println("invalid option");

				break;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book System Program");
		AddressBookMain abm = new AddressBookMain();
		System.out.println("Enter no of person:");
		// int size = sc.nextInt();

		// looping the methord/construtor to add person data in arraylist
		// for (int i = 1; i <= size; i++) {
		abm.addMultiplePerson();
		// }
	}

	public MultipleAddressBook get(String existingBook) {
		// TODO Auto-generated method stub
		return null;
	}

}
