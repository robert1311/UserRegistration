package com.tb.userregistration;

import java.util.Scanner;

public class UserRegistationFrontEnd {
	static Scanner sc = new Scanner(System.in);
	static UserProfileDao dao = new UserProfileDao();

	public static void main(String[] args) {

		boolean keepGoing = true;
		int userOption;
		do {
			System.out.println("\nHello, please select a User option.\n" + 
					"1) Add User\n" + 
					"2) Display All Users\n" + 
					"3) Display One User by ID\n" + 
					"4) Update User\n" + 
					"5) Delete User\n");
			userOption = sc.nextInt();
			sc.nextLine();

			switch (userOption) {
			case 1:
				addUserPrompt();
				break;
			case 2:
				System.out.println("Display All Users");
				break;
			case 3:
				System.out.println("Display One User");
				break;
			case 4:
				System.out.println("Update User");
				break;
			case 5:
				System.out.println("Delete User");
				break;
			}
		} while (keepGoing = true);
	}

	public static void addUserPrompt() {
		UserProfile newUser = new UserProfile();
		boolean hasErrors;
		String firstName = "";
		String lastName = "";
		String email = "";
		do {
			hasErrors = false;
			if(!firstName.isBlank()) {
				//skip
			} else {
				System.out.println("Enter First Name");
				firstName = sc.nextLine();
				hasErrors = !newUser.setFirstName(firstName);
				if (hasErrors) {
					continue;
				}
			}
			if(!lastName.isBlank()) {
				//skip
			} else {
				System.out.println("Enter Last Name");
				lastName = sc.nextLine();
				hasErrors = !newUser.setLastName(lastName);
				if (hasErrors) {
					continue;
				}
			}
			if(!email.isBlank()) {
				//skip
			} else {
				System.out.println("Enter Email");
				email = sc.nextLine();
				hasErrors = !newUser.setEmail(email);
				if (hasErrors) {
					continue;
				}
			}
		} while (hasErrors);
		newUser.setUserProfileId(newUser.getUserCount() + 1);
		dao.addUser(newUser);
		System.out.println("New User Added!");
	}
}
