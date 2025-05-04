package digitalDiary;

import java.util.ArrayList;

public class Login {
	ArrayList<User> users= new ArrayList<>();
	
	public void createUser(User account) {
		for(User user: users) {
			if(user.getUsername().equals(account.getUsername())) {
				System.out.println("\nUsername already in use.");
				return;
			}
		}
		users.add(account);
		System.out.println("\nAccount created successfully.");
	}
	
	public void deleteAccount(User account) {
		if (users.remove(account)) {
			System.out.println("\nAccount deleted successfully.");
		} else {
			System.out.println("\nError, account not found.");
		}
	}
	
	public User login(String username, String password) {
		for (User user: users) {
			if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
				System.out.println("\nWelcome to your account, " + username);
				return user;
			}
		}
		System.out.println("\nIncorrect user name or password.");
		return null;
	}
	
	public void displayUsers() {
		System.out.println("\nDisplaying Users...\n");
		for (User user: users) {
			System.out.println(user.displayUsername());
		}
	}
}
