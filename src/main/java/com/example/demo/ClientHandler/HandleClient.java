package com.example.demo.ClientHandler;
import com.example.demo.Interceptor.Interceptor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class HandleClient implements Runnable {

    Socket connection;
    Integer clientNumber;
    ObjectInputStream input;
    ObjectOutputStream output;
    Object obj;
    List<Object> historyCommands =new ArrayList<>();

    public HandleClient(Socket connection, int clientNumber) {
        this.connection=connection;
        this.clientNumber=clientNumber;
    }

    public void run() {
        try {
            input = new ObjectInputStream(connection.getInputStream());
            output = new ObjectOutputStream(connection.getOutputStream());
            while (true) {
                obj = input.readObject();
                if (obj.equals("exit")) {
                    connection.close();
                }
                //TODO fix history command
                if (obj.equals("history")) {
                   System.out.println(historyCommands);
                   for(Object s : historyCommands){
                       output.writeChars(String.valueOf(s));
                       output.flush();
                   }
                }
               else{
                    historyCommands.add(String.valueOf(obj));
                    Object outputFromAPI = Interceptor.parse(obj);
                    output.writeObject(outputFromAPI);
                }
                output.flush();
            }


        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (IOException | URISyntaxException ioe) {
            ioe.printStackTrace();
        }


    }
}