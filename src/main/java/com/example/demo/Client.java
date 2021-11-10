package com.example.demo;

import com.example.demo.Server.ServerConnection;

import java.io.*;
import java.net.Socket;

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final Integer SERVER_PORT = 9090;
    public static void main(String[] args) throws IOException {

        System.out.println("Client is started");
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);
        ServerConnection serverConnection = new ServerConnection(socket);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        new Thread(serverConnection).start();
        while (true) {
            System.out.println("> ");
            String command = keyboard.readLine();
            if (command.equals("exit")) {
                socket.close();
            } else {
                System.out.println("I AM NOT EXIT");
            }
        }
    }
}
