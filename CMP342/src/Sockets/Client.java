package Sockets;

import java.io.*;
import java.net.*;

public class Client
{
   static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in),1);

   public static void main(String[] args)
   {
      try
      {
         System.out.println("Contacting Server:");
         Socket socket = new Socket("localhost", 8080);

         System.out.println("Setting up Input & Output:");
         DataOutputStream output = new DataOutputStream(socket.getOutputStream());
         DataInputStream input = new DataInputStream(socket.getInputStream());

         System.out.println("Getting Message from user:");
         System.out.print("-> ");
         String message = keyboard.readLine();

         System.out.println("Sending Message to server");
         output.writeUTF(message);


         System.out.println("Waiting for Message from Server:");
         message = input.readUTF();

         System.out.println("Printing Message from Server:");
         System.out.println(message);



         System.out.println("Client Finished");
      }
      catch(IOException x){};

   }

}