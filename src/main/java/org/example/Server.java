package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(26525);) {
            try (Socket clienSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clienSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
            ) {
                System.out.println("New connection accepted");
                final String name = in.readLine();
                System.out.println(String.format("Hi %s, your port is %d", name, clienSocket.getPort()));
            }
        }
        catch(IOException e){
            System.out.println("Can't start server");
            e.printStackTrace();
        }
    }
}