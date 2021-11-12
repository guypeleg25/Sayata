package com.example.demo.ClientHandler;
import com.example.demo.Dao.Model.User;
import com.example.demo.Interceptor.Interceptor;
import org.springframework.data.util.Pair;
import org.springframework.web.client.RestTemplate;

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
    Boolean userLogged = false;


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

                String operationName = Interceptor.getOperationName(String.valueOf(obj));
                if(operationName.equals("login") || operationName.equals("register")){
                    Object outputFromAPI = Interceptor.parse(obj);
                    output.writeObject(outputFromAPI);
                    if(outputFromAPI.equals("Login success")){
                        userLogged = true;
                    }
                    continue;
                }
                if (userLogged) {
                    Object outputFromAPI = Interceptor.parse(obj);
                    output.writeObject(outputFromAPI);
                }
                    if (obj.equals("history")) {
                        System.out.println(historyCommands);
                        for (Object s : historyCommands) {
                            output.writeChars(String.valueOf(s));
                            output.flush();
                        }
                    }
                        if(!userLogged){
                            output.writeObject("You need to login first");
                        }
                        if (obj.equals("exit")) {
                            connection.close();
                        }
                    historyCommands.add(String.valueOf(obj));
                    output.flush();
                }


        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (IOException | URISyntaxException ioe) {
            ioe.printStackTrace();
        }


    }
}