package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        try (Socket sock = new Socket("localhost", 26525);){
            try (PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            ) {
                System.out.println("Connected");
                out.println("Student");
                sock.close();
            }
        }
        catch (UnknownHostException e){
            System.out.println("Host not found");
        }
        catch (IOException e){
            System.out.println("Can't connecet");
            e.printStackTrace();
        }
    }
}
