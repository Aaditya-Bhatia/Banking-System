import java.util.Scanner;

public class Existing {

private String username;
private String password;


public void process(){
	System.out.println("Logging into the system...");
	Driver JDBC_obj = new Driver();
	
	String sql_str = String.format("Select * from user where username = '%1s' and password = '%2s'", this.username, this.password);
	int money = JDBC_obj.getMoney(sql_str);
	System.out.format("you have a $%d money in your account\n", money);
	
	if (money == 0) 
		System.out.println("Go back and add create an acconunt to add some money first!");
	

	Boolean loop = true;
	
	while (loop) {

	System.out.println("What would you like to do?"
			+ "\nPress 1 to add/dithdraw money"
			+ "\nPress 2 to delete account"
			+ "\nPress 3 to check balance"
			+ "\n0 to go back");
	Scanner s = new Scanner(System.in);
	String choice = s.nextLine();

	switch (choice) {
	case "1":
		System.out.println("How much money to be added or removed. Input '-' for removal");
		money = money + s.nextInt();
		JDBC_obj.addMoney(money, username, password);
		break;

	case "2":
		JDBC_obj.delete(this.username, this.password);
		System.out.println("Your account has been deleted");
		break;

	case "3":
		sql_str = String.format("Select * from user where username = '%1s' and password = '%2s'", this.username, this.password);
		money = JDBC_obj.getMoney(sql_str);
		System.out.format("you have $%d money in your account\n", money);
		break;

	case "0":
		loop = false;
		break;
		
	default: 
		break;
	}
	
	}
	
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

}
