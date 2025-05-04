package digitalDiary;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Login login = new Login();
		Scanner scanner = new Scanner(System.in);
		int choice;
		
		System.out.println("Welcome to the Digital Diary");
		
		do {
			System.out.println("\n	1. Log in");
			System.out.println("	2. Create Account");
			System.out.println("	3. Display Current Users");
			System.out.println("	4. Exit Program");
			System.out.print("\nEnter choice: ");
			
			while (!scanner.hasNextInt()) {
				System.out.print("\nError, please enter valid choice: ");
				scanner.nextLine();
			}
				
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
			case 1:
				System.out.print("\nEnter username: ");
				String userLogin = scanner.nextLine();
				System.out.print("\nEnter password: ");
				String passLogin = scanner.nextLine();
				
				User currentUser = login.login(userLogin, passLogin);
				if (currentUser != null) {
					String message = null;
					do {
						System.out.println("\n	1. Write diary entry");
						System.out.println("	2. View diary entry");
						System.out.println("	3. Log Out");
						System.out.println("	4. Delete Account");
						System.out.print("\nEnter choice: ");
						
						while (!scanner.hasNextInt()) {
							System.out.print("\nError, please enter valid choice: ");
							scanner.nextLine();
						}
						
						choice = scanner.nextInt();
						scanner.nextLine();
						
						switch (choice) {
						case 1:
							System.out.print("\nEnter diary entry: ");
							message = scanner.nextLine();
							currentUser.setEntry(message);
							System.out.println("\nDiary entry saved.");
							break;
						case 2:
							if (message == null) {
								System.out.println("\nNo entry available to display.");
								break;
							} else {
								System.out.println("\nDisplaying diary entry... \n\n" + currentUser.getEntry());
								break;
							}
						case 3:
							System.out.println("\nSuccessfully logged out.");
							break;
						case 4:
							System.out.print("\nEnter password to confirm deletion: ");
							String confirmPass = scanner.nextLine();
							
							if(confirmPass.equals(currentUser.getPassword())) {
								login.deleteAccount(currentUser);
								currentUser = null;
								choice = 3;
							} else {
								System.out.println("\nIncorrect password.");
							}
							break;
						default:
							System.out.print("\nError, please enter a valid choice. \n");
						}
					}
					while (choice !=3);
				}
				break;
			case 2:
				System.out.print("\nEnter desired username: ");
				String username = scanner.next();
				System.out.print("\nEnter desired password: ");
				String password = scanner.next();
				login.createUser(new User(username, password));
				break;
			case 3:
				if (login.users.isEmpty()) {
					System.out.println("\nNo users available to display.");
					break;
				}
				login.displayUsers();
				break;
			case 4:
				System.out.println("\nExiting the program...");
				break;
			default:
				System.out.print("\nError, please enter a valid choice. \n");
			}
		}
		while (choice != 4);
		
		scanner.close();
	}

}
