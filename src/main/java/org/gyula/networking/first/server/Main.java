package org.gyula.networking.first.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
	    try(ServerSocket serverSocket = new ServerSocket(5000)) {

            while(true) {
                new Echoer(serverSocket.accept()).start();
//                Socket socket = serverSocket.accept();
//                Echoer echoer = new Echoer(socket);
//                echoer.start();
            }



//            Socket socket = serverSocket.accept();
//            System.out.println("Client Connected");
//            BufferedReader input = new BufferedReader(
//                    new InputStreamReader(socket.getInputStream()));
//            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
//
//            while(true) {
//                String echoString = input.readLine();
//                if(echoString.equals("exit")) {
//                    break;
//                }
//                output.println("Echo from server: " + echoString);
//            }


        } catch(IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }
}
