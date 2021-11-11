package com.example.demo;

import com.example.demo.Controller.Bo.CreateSubmissionInput;
import com.example.demo.Interceptor.Interceptor;
import com.example.demo.Util.Builder;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

 public class HandleClient implements Runnable
{
    Socket connection;
    int clientNumber;
    ObjectInputStream input;
    ObjectOutputStream output;
    Object obj;
    Interceptor interceptor;
    final RestTemplate restTemplate = new RestTemplate();
    String currentUrl = "http://localhost:8080/home/createSubmission";

    public HandleClient(Socket connection, int clientNumber)
    {
        this.connection=connection;
        this.clientNumber=clientNumber;
    }

    public void run() {
        try {
            input = new ObjectInputStream(connection.getInputStream());
            output = new ObjectOutputStream(connection.getOutputStream());

            while (true) {
                obj = input.readObject();
                if (obj instanceof String) {
                    System.out.println(obj);
                    Object input = Interceptor.parse(obj);
                    final Object s = restTemplate.postForObject(currentUrl,input,String.class);
                    output.writeObject(s);
                }
                if (obj.equals("exit")) {
                    connection.close();
                }

                output.writeObject(obj);
                output.flush();
            }


        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }
}