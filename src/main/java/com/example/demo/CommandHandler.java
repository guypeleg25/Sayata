package com.example.demo;

import com.example.demo.Interceptor.Interceptor;

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

        if(!userLogged){
            return ("You need to login first");
        }

        if(operationName.equals("exit")){
            return  "Hasta la vista baby";
        }

        return null;

    }
}
