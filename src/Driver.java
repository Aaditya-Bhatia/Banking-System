/*
 * Author: @Aaditya Bhatia
 * Need to download driver from dev.mysql.com/downloads/connector/j/
 * Need to use JDBC compliant timezone to resolve timezone error
 */



import java.sql.*;

public class Driver {
	
	private Connection con;
	
	public Driver() {
		
		try {
			// get connection 
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "xxxx");				
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getMoney(String SQL_str) {
		int money = 0;

		try {
			Statement myStmnt = con.createStatement();
			ResultSet myRes = myStmnt.executeQuery(SQL_str);
			if (myRes.next()) {
			money = myRes.getInt("money");
		}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return money;
	}
	
	public void addMoney(int money, String username, String password) {
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = con.prepareStatement("Update user set money = ? where "
					+ "username = ? and password = ?");
            preparedStatement.setInt(1, money);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            boolean b=preparedStatement.execute();
            if(b==true)
                   System.out.println("1 record updated...");
            
		}

		 catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String username,String password) {
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = con.prepareStatement("Delete from user where "
					+ "username = ? and password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            boolean b=preparedStatement.execute();
            if(b==true)
                   System.out.println("1 record deleted");
            
		}

		 catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void create_user(String username, String password, int money) {
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = con.prepareStatement("Insert into user(username, password, money)"
					+ "values (?, ?, ?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, money);
            boolean b=preparedStatement.execute();
            if(b==true)
                   System.out.println("1 record inserted...");
		}

		 catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
}