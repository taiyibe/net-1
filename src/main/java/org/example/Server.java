package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        String city = null;
        try (ServerSocket serverSocket = new ServerSocket(26525);) {
            while(true){
                try (Socket clienSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clienSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
                ) {
                    if (city == null){
                        out.println("???");
                        city = in.readLine();
                        out.println("OK");
                    }
                    else {
                        out.println(city);
                        String buf = in.readLine();
                        if (city.charAt(city.length() - 1) == buf.charAt(0)){
                            city = buf;
                            out.println("OK");
                        }
                        else{
                            out.println("NOT OK");
                        }
                    }
                }
            }
        }
        catch(IOException e){
            System.out.println("Can't start server");
            e.printStackTrace();
        }
    }
}