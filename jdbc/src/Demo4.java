import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo4 {
	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("Driver loaded");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Root");
			System.out.println("Connection established");
			String s = "update student set name=? where id=?";
			PreparedStatement pstmt=con.prepareStatement(s);
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter name");
			String name = scan.next();
			System.out.println("Enter the id");
			int id = scan.nextInt();
			pstmt.setString(1,name);
			pstmt.setInt(2,id);
			int rows =pstmt.executeUpdate();
			System.out.println(rows);
			
		
	}
}
