package com.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookMain {
	public AddressBookMain() {
		this.setPerson(person);
	}

	static Scanner sc = new Scanner(System.in);
	private static ArrayList<PersonContact> person;
	List<PersonContact> contactDetailsList = new ArrayList<>();
	MultipleAddressBook multipleAddressBook = new MultipleAddressBook();

	public MultipleAddressBook get(String existingBook) {
		// TODO Auto-generated method stub
		return null;
	}

	public static ArrayList<PersonContact> getPerson() {
		return person;
	}

	public void setPerson(ArrayList<PersonContact> person) {
		AddressBookMain.person = person;
	}

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
		for (PersonContact i : getPerson()) {
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
		for (int i = 0; i < getPerson().size(); i++) {// get contacts for whole array list
			PersonContact pc1 = (PersonContact) getPerson().get(i);
			if (editinput.equals(pc1.getFirstName())) {
				newcontact();/// calling add person to replace
				for (int j = 0; j < getPerson().size(); j++) {
					getPerson().set(j, pc1);
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

		for (int i = 0; i < getPerson().size(); i++) {
			PersonContact p = (PersonContact) getPerson().get(i);
			if (s.equals(p.getFirstName())) {
				System.out.println(p);
				getPerson().remove(i);
				System.out.println("Contact Deleted");
			} else {
				System.out.println("No matches found for given first name.");
			}
		}
	}

	/**
	 * create method searchByCity that is Ability to search Person across the
	 * multiple AddressBook by City
	 * 
	 * @param name -passing City name
	 */
	public void searchByCity(String city) {
		List<PersonContact> collect = contactDetailsList.stream().filter(p -> p.getCity().equalsIgnoreCase(city))
				.collect(Collectors.toList());
		for (PersonContact contact : collect) {
			System.out.println("Search result: " + contact);
		}
	}

	/**
	 * create method searchByState that is Ability to search Person across the
	 * multiple AddressBook by State
	 * 
	 * @param name -passing State name
	 */
	public void searchByState(String state) {
		List<PersonContact> collect = contactDetailsList.stream().filter(p -> p.getCity().equalsIgnoreCase(state))
				.collect(Collectors.toList());
		for (PersonContact contact : collect) {
			System.out.println("Search result: " + contact);
		}
	}

	public void displayPeopleByRegion(HashMap<String, ArrayList<PersonContact>> addressBookMap) {
		List<PersonContact> contacts;
		for (String city : addressBookMap.keySet()) {
			System.out.println("People residing in: " + city);
			contacts = addressBookMap.get(city);
			for (PersonContact contact : contacts) {
				System.out.println(contact);
			}
		}
	}

	public void addMultiplePerson() {
		while (true) {
			System.out.println("Enter the option \n" + "1)To Add New Address Book\n" + "2)To Add New Contact\n"
					+ "3)To Check Duplicate Contact" + "4)To Edit Contact" + "\n5)To Delete Contact"
					+ "\n6)To searching Contact by State or City" + "\n7)To Print Address Books \nSorting data by Name \n9)Exit");
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
				multipleAddressBook.searchcrs();
			case 7:
				multipleAddressBook.displayPeopleByRegion();
				break;
			case 8:
				multipleAddressBook.sortByName();
				break;
			case 9: {
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

}
