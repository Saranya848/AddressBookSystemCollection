package com.collections;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
	static Scanner sc = new Scanner(System.in);
	ArrayList<PersonContact> person;

	/**
	 * adding new contact in Book
	 */
	public void newcontact() {

		System.out.println("Enter First Name: ");
		String firstname = sc.nextLine();

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
		String input = sc.next();

		for (int i = 0; i < person.size(); i++) {
			PersonContact pc1 = (PersonContact) person.get(i);
			if (input.equals(pc1.getFirstName())) {
				System.out.println(pc1);
				person.remove(i);
				System.out.println("Contact Deleted");
			} else {
				System.out.println("No matches found for given first name.");
			}
		}
	}

	public void addMultiplePerson() {
		while (true) {
			System.out.println("Enter the option \n1)To Add Contect" + "\n2)To Edit Contact" + "\n3)To Delete Contact"
					+ "\n4)exit");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				newcontact();
				break;
			case 2:
				editPerson();
				break;
			case 3:
				deletePerson();
				break;
			case 4:
				System.out.println("You are out of the address book system");
				break;

			default:
				System.out.println("invalid option");
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book System Program");
		AddressBookMain abm = new AddressBookMain();
		System.out.println("Enter no of person:");
		int size = sc.nextInt();

		// looping the methord/construtor to add person data in arraylist
		for (int i = 1; i <= size; i++) {
			abm.addMultiplePerson();
		}
	}

	public AddressBookMain get(String existingBook) {
		// TODO Auto-generated method stub
		return null;
	}

}
