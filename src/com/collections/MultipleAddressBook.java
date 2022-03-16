package com.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MultipleAddressBook {

	/**
	 * Hash map created for Multiple Address Books with Name and
	 * AddressBookSystemMain object
	 */
	Map<String, AddressBookMain> addressbook = new HashMap<>();
	/**
	 * Scanner function for user input
	 */
	Scanner scanner = new Scanner(System.in);

	/**
	 * Method to create new address book First took user input to search through
	 * hashMap If matched: Shows message Book Already Exists If not: Create new
	 * addressBookSystem object with hashMap
	 */
	public void addressBookAddition() {

		System.out.println("Enter name of the address book");
		String bookName = scanner.next();
		if (addressbook.containsKey(bookName)) {
			System.out.println("Book Already Exists");
		} else {
			AddressBookMain obj = new AddressBookMain();
			addressbook.put(bookName, obj);
			System.out.println("New Address Book Created with name: " + bookName);
		}

	}

	/**
	 * Method to add contact in specific Address Book Took user input to search
	 * through HashMap If found: calling addPerson Method
	 */
	public void addingContacts() {
		System.out.println("Enter name of address book you want to add contact in");
		String existingBook = scanner.next();
		AddressBookMain addressBook = addressbook.get(existingBook);
		if (addressBook == null) {
			System.out.println("No adress book exists with given name");
		} else {
			addressBook.get(existingBook).newcontact();
		}
	}

	/**
	 * Method to edit contact in specific Address Book Took user input to search
	 * through HashMap If found: calling editPerson Method
	 */
	public void editingContacts() {
		System.out.println("Enter name of address book you want to edit contact in");
		String existingBook = scanner.next();
		AddressBookMain addressBook = addressbook.get(existingBook);
		if (addressBook == null) {
			System.out.println("No adress book exists with given name");
		} else {
			addressBook.get(existingBook).editPerson();
		}
	}

	/**
	 * Method to delete contact in specific Address Book Took user input to search
	 * through HashMap If found: calling deletePerson Method
	 */
	public void deletingContacts() {
		System.out.println("Enter name of address book you want to delete contact in");
		String existingBook = scanner.next();
		AddressBookMain addressBook = addressbook.get(existingBook);
		if (addressBook == null) {
			System.out.println("No adress book exists with given name");
		} else {
			addressBook.get(existingBook).deletePerson();
		}
	}

	private void deletePerson() {
		// TODO Auto-generated method stub

	}

	/**
	 * Method to print AddressBooks for every element of addressBookSystem(defined
	 * by i). print i get object existing with i and print result
	 */
	public void printAddressBook() {
		for (String i : addressbook.keySet()) {
			System.out.println(i);
			System.out.println(addressbook.get(i).person);
		}
	}

	public void newcontact() {
		// TODO Auto-generated method stub

	}

	public void editPerson() {
		// TODO Auto-generated method stub

	}
}
