package Sockets;
import java.io.*;
import java.net.*;

public class Server
{
   static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in),1);

   public static void main(String[] args)
   {
      try
      {
         System.out.println("Create Server:");
         ServerSocket server = new ServerSocket(8080);

         System.out.println("Waiting for Client:");
         Socket socket = server.accept();

         System.out.println("Seting up Input and Output");
         DataInputStream input = new DataInputStream(socket.getInputStream());
         DataOutputStream output = new DataOutputStream(socket.getOutputStream());

         System.out.println("Waiting for Message from Client:");
         String message = input.readUTF();

        System.out.println("Displaying Message from Client:");
        System.out.println(message);


         System.out.println("Getting Message from user:");
         System.out.print("-> ");
         message = keyboard.readLine();

         System.out.println("Sending Message to Client");
         output.writeUTF(message);


        System.out.println("Server Finished");

      }
      catch(IOException x){};


   }

}
