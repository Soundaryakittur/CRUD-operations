import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LaunchUser {
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("1.register: \n2.Login:");
		System.out.println("Enter your choice:");
		int n=sc.nextInt();
		switch(n) {
		case 1:register();
			   break;
		case 2:login();
			   break;
		}
		
	}

	static void register() throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver loaded");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","Root");
		System.out.println("Connection established");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name");
		String name=sc.next();
		System.out.println("Enter the Username");
		String username=sc.next();
		
		while(true) {
			String s = "select * from user where username=?";
			PreparedStatement pstmt=con.prepareStatement(s);
			pstmt.setString(1, username);
			ResultSet res= pstmt.executeQuery();
			if(res.next()) {
				System.out.println("username already exist.please enter another username");
				username=sc.next();
			}
			else {
				break;
			}
		}
		String password;
		String confirm_password;
		do {
			System.out.println("Enter the Password");
			password=sc.next();
			System.out.println("Enter the Confirm Password");
			confirm_password=sc.next();
		}while(!password.equals(confirm_password));
		System.out.println("password and confirm_password are same");
		
		System.out.println("Enter the Email");
		String email=sc.next();
		String s1 = "insert into user value(?, ?, ?, ?)";
		PreparedStatement pstmt=con.prepareStatement(s1);
		pstmt.setString(1,name);
		pstmt.setString(2,username);
		pstmt.setString(3,password);
		pstmt.setString(4,email);
		pstmt.executeUpdate();
		
	
	}
	static void login() throws Exception {
		// TODO Auto-generated method stub
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver loaded");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","Root");
		System.out.println("Connection established");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Username");
		String username=sc.next();
		System.out.println("Enter the Password");
		String password=sc.next();
		String s = "select * from user where username=?";
		PreparedStatement pstmt=con.prepareStatement(s);
		pstmt.setString(1, username);
		ResultSet res= pstmt.executeQuery();
		if(res.next()) {
			if(password.equals(res.getString(3))) {
				System.out.print("Login Successful");
			}
			else {
				System.out.print("Invalid Password");
			}
		}
		else {
			System.out.print("Invalid Password");
		}
		
	}
}