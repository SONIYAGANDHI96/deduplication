import java.net.*;
import java.io.*;
public class GClient
  {
    public static void main(String [] args)
      {
        String serverName = "localhost";
        int port = Integer.parseInt("5005");
       try
         {
           System.out.println("Connecting to " + serverName +
     " on port " + port);
           Socket client = new Socket(serverName, port);
           System.out.println("Just connected to " 
     + client.getRemoteSocketAddress());
          client.close();
       }catch(IOException e)
          {
             e.printStackTrace();
          } 
      }
 }
