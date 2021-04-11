package com.tb.userregistration;

import java.util.ArrayList;
import java.util.List;

public class UserProfileDao {

	ArrayList<UserProfile> users = new ArrayList<>();
	int userId = 0;
	
	public void addUser(UserProfile user) {
		user.setUserProfileId(userId);
		userId++;
		users.add(user);
	}
	
	public UserProfile getUser(int userId) {
		UserProfile selectedUser = null;
		for(UserProfile user: users) {
			if(user.getUserProfileId() == userId) {
				selectedUser = user;;
			}
		}
		return selectedUser;
	}
	
	public List<UserProfile> getAllUsers(){
		return users;
	}
	
	public void updateUser(UserProfile user) {
		users.add(user);
	}
	
	public void deleteUser(int userId) {
		users.remove(userId);
	}
}
