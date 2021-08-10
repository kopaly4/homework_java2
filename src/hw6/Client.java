package hw6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.Socket;
import java.util.Scanner;

public class Client{

    static final String IP_ADDRESS = "localhost";
    static final int PORT = 7978;
    public static void main(String[] args) {
        Socket socket = null;
        Scanner sc = new Scanner(System.in);

        try {
            socket = new Socket(IP_ADDRESS, PORT);
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
                    System.out.println("Server connection has been lost");
                    out.writeUTF("/end");
                    break;
                }
                System.out.println("Server: " + str);
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
