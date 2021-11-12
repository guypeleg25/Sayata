package com.example.demo.Server;

import com.example.demo.ClientHandler.HandleClient;
import com.example.demo.Util.Constants;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket connection;
        Integer clientNumber = 1;

        try {
            serverSocket = new ServerSocket(Constants.SERVER_PORT);
            System.out.println("Waiting on Client");
            ExecutorService threadExecutor = Executors.newCachedThreadPool();

            while(true) {
                connection=serverSocket.accept();
                System.out.println("Starting Thread for client "+clientNumber);
                HandleClient thread=new HandleClient(connection,clientNumber);
                threadExecutor.execute(thread);
                clientNumber++;
            }
        }

        catch(IOException ioe) {
            ioe.printStackTrace();
        }

    }
}



