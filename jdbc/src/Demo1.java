
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Demo1 {
	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());  //Load driver class present in com.mysql.cj.jdbc
		System.out.println("Driver is loadedr");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Root");  //(jdbc=api, mqsql=vendor, localhost=Ip address, student=DB name, username, password//
		System.out.println("Connection Establish");
		String s ="select * from student";
		Statement stmt = con.createStatement();  //  A Statement object is created to send SQL queries to db using createStatement() 
		ResultSet res= stmt.executeQuery(s);    // Execute the query that is passed and return the Resultset
		while(res.next()==true) {               //Move the cursor to the next row , return true if row exist else return false.//     
			int id =res.getInt(1);				// Accessing data using column index. OR May be Column Name For EX: int id =res.getInt("id");	
			String name = res.getString(2);
			int marks1 =res.getInt(3);
			int marks2 =res.getInt(4);
			int marks3 =res.getInt(5);
			System.out.println(id+" "+name+" "+marks1+" "+marks2+" "+marks3);
		}
		
		
	}
}

/*Upon downloading the compressed zip file, proceed to extract its contents. Any task needs to take place within the computer's Random Access Memory (RAM). 
 In the context of our Java program, all necessary elements must reside within the program to ensure effective execution
 

Adding Driver Software into Eclipse

Step 1: Create a new java project and name the project as "jdbc", and click on finish.
Step 2: Right-click on the project "jdbc", click on properties
Step 3: Click on 'Java Build Path', now click on the "Libraries' tab
Step 4: Click on 'Classpath', (now all the buttons will be enabled).
Step 5: Click on the "Add External JARs' button.
Step 6: Now select the 'mysql connector' file which you had previously downloaded and click on 'open'.
Step 7: Click on 'Apply'. And as soon as we click on 'Apply', a new folder "Referenced Libraries will be created.
Step 8: Click on 'Apply and Close'

Upon expanding the 'Referenced Libraries' folder, you'll notice the inclusion of the 'mysql- connector-java-8.0.25.jar' JAR file. 
A JAR file is a container for numerous Java class files. 
Within this JAR file, there exists a Driver class crucial for interacting with the database.*/
