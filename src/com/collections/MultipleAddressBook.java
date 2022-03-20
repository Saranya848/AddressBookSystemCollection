package com.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.stream.Collectors;

public class MultipleAddressBook {

	/**
	 * Hash map created for Multiple Address Books with Name and
	 * AddressBookSystemMain object
	 */
	Map<String, AddressBookMain> addressbook = new HashMap<>();
	List<PersonContact> contacts = new ArrayList<PersonContact>();
	/**
	 * Scanner function for user input
	 */
	Scanner scanner = new Scanner(System.in);
	private Map<String, AddressBookMain> person;

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
	public void duplicateContacts() {
		System.out.println("Enter name of address book you want to edit contact in");
		String existingBook = scanner.next();
		AddressBookMain addressBook = addressbook.get(existingBook);
		if (addressBook == null) {
			System.out.println("No adress book exists with given name");
		} else {
			addressBook.get(existingBook).duplicateCheck();
		}
	}

	private void duplicateCheck() {
		// TODO Auto-generated method stub

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
	 * Method to searching the person by the city 1. We are using a advanced for
	 * loop to get all the keys 2. Then we are saving contacts to the list. 3. Then
	 * we are using the streams filter to get the contact matching the city and then
	 * printing it.
	 */
	public void searchByCity() {

		System.out.println("Enter the name of the City to get the persons : ");
		String cityName = scanner.next();
		for (String i : addressbook.keySet()) {
			addressbook.get(i);
			List<PersonContact> arr = AddressBookMain.getPerson();
			arr.stream().filter(person -> person.getCity().equals(cityName))
					.forEach(person -> System.out.println(person.getFirstName()));
		}
	}

	public void searchcrs() {
		while (true) {
			System.out.println("Enter the option \n" + "1)To search person details by state\n"
					+ "2)To search person details by city\n3)Exit");
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				searchByState();
				break;
			case 2:
				searchByCity();
				break;
			case 3: {
				System.out.println("You are out of the address book system");
			}

				break;
			default:
				System.out.println("invalid option");

				break;
			}
		}
	}

	/**
	 * Method to searching the person by the state 1. We are using a advanced for
	 * loop to get all the keys 2. Then we are saving contacts to the list. 3. Then
	 * we are using the streams filter to get the contact matching the state and
	 * then printing it.
	 */
	public void searchByState() {

		System.out.println("Enter the name of the State to the get persons : ");
		String stateName = scanner.next();
		for (String i : addressbook.keySet()) {
			addressbook.get(i);
			List<PersonContact> arr = AddressBookMain.getPerson();
			arr.stream().filter(person -> person.getState().equals(stateName))
					.forEach(person -> System.out.println(person.getFirstName()));
		}
	}

	public void newcontact() {
		// TODO Auto-generated method stub

	}

	public void editPerson() {
		// TODO Auto-generated method stub

	}

	/**
	 * Method to searching the person by the city 1. We are using a advanced for
	 * loop to get all the keys 2. Then we are saving contacts to the list. 3. Then
	 * we are using the streams filter to get the contact matching the city and then
	 * printing it.
	 */
	public void displayPeopleByRegion() {

		System.out.println("Enter the name of the persons : ");
		String firstname = scanner.next();
		for (String i : addressbook.keySet()) {
			addressbook.get(i);
			List<PersonContact> arr = AddressBookMain.getPerson();
			arr.stream().filter(person -> person.getCity().equals(firstname))
					.forEach(person -> System.out.println(person.getFirstName()));
		}
	}

	/**
	 * Declaring Sort Method Sorting The Details Of Contact By Using Names Using
	 * Stream method
	 */
	public void sortByName() {
		Collection<PersonContact> collection = (Collection<PersonContact>) person;
		List<PersonContact> list = collection.stream().collect(Collectors.toList());
		list.stream().sorted((g1, g2) -> ((String) g1.getFirstName()).compareTo(g2.getFirstName()))
				.forEach(contact -> System.out.println(contact.getFirstName() + " " + contact.getLastName()));
	}
}