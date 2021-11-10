package com.example.demo.ClientHandler;

import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private ArrayList<ClientHandler> clients;
    final RestTemplate restTemplate = new RestTemplate();
    String currentUrl = "http://localhost:8080/home/createSubmission";
    public ClientHandler(Socket clientSocket , ArrayList<ClientHandler> clients) throws IOException{
        this.client = clientSocket;
        this.clients = clients;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream());
    }
    @Override
    public void run() {
        try{
            while(true){
                System.out.println("HEY I AM RUNNER");
                final String s = restTemplate.getForObject(currentUrl,String.class);
                String request = in.readLine();
                request.equals("create");
                System.out.println("AFTER WITH s " + s);

            }
        } catch (IOException e) {
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



//    @Override
//    public void handleClient(InputStream in, OutputStream out ,Socket client) {
//        BufferedReader userInput = new BufferedReader(new InputStreamReader(in));
//        PrintWriter outToUser = new PrintWriter(out);
//        System.out.println("Handling Client . . . " );
//        System.out.flush();
//
//        String line = "";
//        try {
//            while (!(line = userInput.readLine()).equals("exit")) {
//
//                System.out.println("Client has requested to invert: " + line);
//                }
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//        try {
//            userInput.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        outToUser.close();
//    }

}
