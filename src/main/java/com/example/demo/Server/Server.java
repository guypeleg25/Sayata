package com.example.demo.Server;

import com.example.demo.HandleClient;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Server
{

    public static void main(String[] args)
    {

        ServerSocket serverSocket;
        Socket connection;
        int clientNumber=1;

        try
        {
            serverSocket=new ServerSocket(8000);
            System.out.println("Waiting on Client");

            ExecutorService threadExecutor =Executors.newCachedThreadPool();

            while(true)
            {
                connection=serverSocket.accept();
                System.out.println("Starting Thread for Client "+clientNumber);
                HandleClient thread=new HandleClient(connection,clientNumber);
                threadExecutor.execute(thread);
                clientNumber++;
            }

        }

        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }

    }
}



