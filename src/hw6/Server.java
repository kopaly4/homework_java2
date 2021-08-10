package hw6;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server{
    public static void main(String[] args) {
        Socket socket = null;
        Scanner sc = new Scanner(System.in);

       try (ServerSocket server = new ServerSocket(7978)){
           System.out.println("Server has been started");
           socket = server.accept();
           System.out.println("Client has been joined");
           DataInputStream in = new DataInputStream(socket.getInputStream());
           DataOutputStream out = new DataOutputStream(socket.getOutputStream());

           Thread thread = new Thread (() -> {
               try {
                   while(true) {
                       out.writeUTF(sc.nextLine());
                   }
               } catch (IOException e){
                   e.printStackTrace();
               }
           });
           thread.setDaemon(true);
           thread.start();
           while(true) {
               String str = in.readUTF();
               if(str.equals("/end")){
                   System.out.println("Client has left from the server");
                   break;
               }
               System.out.println("Client: " + str);
           }
       } catch(IOException e){
        e.printStackTrace();
    } finally {
           try{
               socket.close();
           } catch (IOException e){
               e.printStackTrace();
           }
       }

       }
}
