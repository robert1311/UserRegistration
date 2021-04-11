package com.tb.userregistration;

public class UserProfile {
	private int userProfileId;
	private String firstName;
	private String lastName;
	private String email;
	private int userCount = 0;

	/**
	 * @return the userProfileId
	 */
	public int getUserProfileId() {
		return userProfileId;
	}

	/**
	 * @param userProfileId the userProfileId to set
	 */
	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public boolean setFirstName(String firstName) {
		if (!firstName.isBlank()) {
			this.firstName = firstName;
			return true;
		} else {
			System.out.println("First Name can't be blank");
			return false;
		}
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public boolean setLastName(String lastName) {
		if (!lastName.isBlank()) {
			this.lastName = lastName;
			return true;
		} else {
			System.out.println("Last Name can't be blank");
			return false;
		}

	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public boolean setEmail(String email) {
		if (!email.isBlank()) {
			this.email = email;
			return true;
		} else {
			System.out.println("Email can't be blank");
			return false;
		}

	}

	/**
	 * @return the userCount
	 */
	public int getUserCount() {
		return userCount;
	}
	
	

}
