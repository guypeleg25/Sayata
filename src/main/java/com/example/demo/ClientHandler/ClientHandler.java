package com.example.demo.ClientHandler;

import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private ArrayList<ClientHandler> clients;
    final RestTemplate restTemplate = new RestTemplate();
    String currentUrl = "http://localhost:8080/home/createSubmission";

    public ClientHandler(Socket clientSocket, ArrayList<ClientHandler> clients) throws IOException {
        this.client = clientSocket;
        this.clients = clients;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("HEY I AM RUNNER");
                final String s = restTemplate.getForObject(currentUrl, String.class);
                String request = in.readLine();
                request.equals("create");

            }
        } catch (IOException e) {
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

