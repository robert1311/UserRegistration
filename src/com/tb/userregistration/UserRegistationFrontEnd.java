package com.tb.userregistration;

import java.util.List;
import java.util.Scanner;

public class UserRegistationFrontEnd {
	static Scanner sc = new Scanner(System.in);
	static UserProfileDao dao = new UserProfileDao();

	public static void main(String[] args) {

		boolean keepGoing = true;
		int userOption;
		do {
			System.out.println("\nHello, please select a User option.\n" + "1) Add User\n" + "2) Display All Users\n"
					+ "3) Display One User by ID\n" + "4) Update User\n" + "5) Delete User\n" + "6) Exit\n");
			userOption = sc.nextInt();
			sc.nextLine();

			switch (userOption) {
			case 1:
				addUserPrompt();
				break;
			case 2:
				displayAllUsers();
				break;
			case 3:
				displayOneUser();
				break;
			case 4:
				System.out.println("Update User");
				break;
			case 5:
				displayRemoveUserPrompt();
				break;
			case 6:
				keepGoing = false;
				break;
			}
		} while (keepGoing);
		System.out.println("Good Bye!");
	}

	public static void addUserPrompt() {
		UserProfile newUser = new UserProfile();
		boolean hasErrors;
		String firstName = "";
		String lastName = "";
		String email = "";
		do {
			hasErrors = false;
			if (!firstName.isBlank()) {
				// skip
			} else {
				System.out.println("Enter First Name");
				firstName = sc.nextLine();
				hasErrors = !newUser.setFirstName(firstName);
				if (hasErrors) {
					continue;
				}
			}
			if (!lastName.isBlank()) {
				// skip
			} else {
				System.out.println("Enter Last Name");
				lastName = sc.nextLine();
				hasErrors = !newUser.setLastName(lastName);
				if (hasErrors) {
					continue;
				}
			}
			if (!email.isBlank()) {
				// skip
			} else {
				System.out.println("Enter Email");
				email = sc.nextLine();
				hasErrors = !newUser.setEmail(email);
				if (hasErrors) {
					continue;
				}
			}
		} while (hasErrors);
		dao.addUser(newUser);
		System.out.println("New User Added!");
	}

	public static void displayAllUsers() {
		List<UserProfile> users = dao.getAllUsers();
		for (UserProfile user : users) {
			System.out.println(user.getUserProfileId() + ") " + user.getFirstName() + " " + user.getLastName() + "\n"
					+ " - " + user.getEmail());
		}
	}

	public static void displayOneUser() {
		System.out.println("Enter User ID to display User.");
		int id = sc.nextInt();
		UserProfile user = dao.getUser(id);
		System.out.println(user.getUserProfileId() + ") " + user.getFirstName() + " " + user.getLastName() + "\n"
				+ " - " + user.getEmail());
	}

	public static void displayRemoveUserPrompt() {

		int id;
		boolean isValid;
		do {
			isValid = false;
			if (dao.getAllUsers().size() <= 0) {
				break;
			}
			System.out.println("Enter an existing User ID to delete User.");
			id = sc.nextInt();
			isValid = dao.deleteUser(id);
			if (isValid) {
				System.out.println("User Removed!");
			}
		} while (!isValid);

	}
}
