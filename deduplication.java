

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.*;
import java.util.*;
 class test
{
	public static void main(String args[]) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");  
                Connection con=null;
                con=DriverManager.getConnection("jdbc:mysql://localhost/mysql","root","root");                           
                Scanner sc=new Scanner(System.in);
	        String databaseUsername = "";
                String databasePassword = "";
                System.out.println("1.signup 2.login");
	        int a=sc.nextInt();
                Statement st=null;
                ResultSet rs=null;
                if(a==1)
	               {
		             System.out.print("Enter Username: ");
                             String name = sc.next();
                             System.out.print("Enter Password: ");
                             String password = sc.next();
	                     st=con.createStatement();
	                     String S="insert into login(uname,upassword) values('"+name+"','"+password+"')";
	                     st.executeUpdate(S);
	                }
	      else{
                            System.out.print("Enter Username: ");
                            String name = sc.next();
                            System.out.print("Enter Password: ");
                            String password = sc.next();
                            st = con.createStatement();
                            String SQL = "SELECT * FROM login WHERE uname='" + name + "' && upassword='" + password+ "'";
                            rs = st.executeQuery(SQL);
                                while (rs.next()) {
                                 databaseUsername = rs.getString("uname");
                                 databasePassword = rs.getString("upassword");
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