package com.example.demo.Server;

import com.example.demo.ClientHandler.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static final int PORT = 9090;
    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while(true){
            System.out.println("Waiting for client");
            Socket client = serverSocket.accept();
            System.out.println("Connected to client");
            ClientHandler clientThread = new ClientHandler(client,clients);
            //clientThread.run();
            clients.add(clientThread);
            pool.execute(clientThread);
        }
    }
}
