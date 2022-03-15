package com.collections;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
	Scanner sc = new Scanner(System.in);
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

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book System Program");
		AddressBookMain ab = new AddressBookMain();
		/**
		 * calling add method
		 */
		ab.newcontact();
	}
}
