 import java.io.*;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.SQLException;
public class Authenticate
{
	public static void main(String args[]) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");  
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","","");                           

		Scanner sc=new Scanner();
	String databaseUsername = "";
    String databasePassword = "";
     System.out.println("1.signup 2.login");
	 int a=sc.nextInt();
    if(a==1)
	{
		
	 System.out.print("Enter Username: ");
    String name = sc.next();
    System.out.print("Enter Password: ");
    String password = sc.next();
	Statement st=con.createStatement();
	String S="insert into users vlaues(name,password);
	Resultset rs=st.executeQuery(s);
	}
	else{
    System.out.print("Enter Username: ");
    String name = sc.next();
    System.out.print("Enter Password: ");
    String password = sc.next();

            // Create SQL Query
    Statement stmt = connection.createStatement();
    String SQL = "SELECT * FROM users WHERE users_name='" + name + "' && users_password='" + password+ "'";
    ResultSet rs = stmt.executeQuery(SQL);

            // Check Username and Password
    while (rs.next()) {
        databaseUsername = rs.getString("users_name");
        databasePassword = rs.getString("users_password");
    }

    if (name.equals(databaseUsername) && password.equals(databasePassword)) {
        System.out.println("Successful Login!\n----");
    }
	else {
        System.out.println("Incorrect Password\n----");
    }
	}
	
	
}
}