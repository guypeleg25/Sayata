package com.example.demo.ClientHandler;
import com.example.demo.CommandHandler;
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
    Object command;
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

                command = input.readObject();
                historyCommands.add(command);
                String operationName = Interceptor.getOperationName(String.valueOf(command));

                Object outputFromApi = userLogged ? CommandHandler.commandHandLer(operationName, command, true,historyCommands) :
                            CommandHandler.commandHandLer(operationName, command, false,historyCommands);
                    output.writeObject(outputFromApi);
                    if (outputFromApi.equals("Login success")) userLogged = true;
                    if (outputFromApi.equals("You need to login first")) continue;
                }


        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (IOException | URISyntaxException ioe) {
            ioe.printStackTrace();
        }


    }
}