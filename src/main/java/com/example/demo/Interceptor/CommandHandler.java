package com.example.demo.Interceptor;

import java.net.URISyntaxException;
import java.util.List;

public class CommandHandler {

    public static Object commandHandLer(String operationName , Object obj , Boolean userLogged, List<Object> historyCommands) throws URISyntaxException {

        if(operationName.equals("login") || operationName.equals("register")) {
            return Interceptor.parse(obj);
        }
        if(operationName.equals("history") && userLogged){
            return historyCommands;
        }
        if (userLogged && !obj.equals("history")) {
           return Interceptor.parse(obj);
        }

        if(operationName.equals("exit")){
            return "Hasta la vista baby";
        }

        if(!userLogged){
            return ("You need to login first");
        }

        return null;

    }
}
