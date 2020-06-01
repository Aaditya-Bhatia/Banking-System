import java.util.Scanner;

public class Bank {

private String username;
private String password;

	public static void main(String[] args) {		
		String isAccount;
		Boolean loop = true;
		
		Scanner in = new Scanner(System.in);
		
		while (loop == true) {
		System.out.println("Welcome to the Banking system. Do you have an account Y/N?"
				+ "\n Press 0 to exit");
		
			
			isAccount = in.nextLine();
			isAccount = isAccount.toLowerCase();
			
			if (isAccount.equals("y")) {
				System.out.println("Enter your user name");
				String username= in.nextLine();
				
				System.out.println("Enter your password");
				String password = in.nextLine();
				
				// processing the information
				Existing e1  = new Existing();
				e1.setPassword(password);
				e1.setUsername(username);
				
				e1.process();
				continue;

			}
			else if (isAccount.equals("n")) {
				System.out.println("Welcome to the new account portal"
						+ "\nEnter your name, password, money you would like to deposit");
				String username= in.nextLine();
				String password = in.nextLine();
				int money = in.nextInt();
				
				Driver d_obj = new Driver();
				d_obj.create_user(username, password, money);
				System.out.println("Your account has been created.");
				continue;
			}

			else if (isAccount.equals("0")) {
				loop = false;
			}
			
		}
		
		System.out.println(" Exiting.");
		System.exit(0);
	}
}
