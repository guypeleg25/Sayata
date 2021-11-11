package com.example.demo.Interceptor;

import com.example.demo.Util.Builder;

import java.util.HashMap;

public class Interceptor {

    //TODO move to consts
    HashMap<String,String> map = new HashMap<>();
    public static String checkOperation(String string) {
        if (string.contains(" ")) {
            string = string.substring(0, string.indexOf(" "));
        }
        return string;

    }

    public static Object parse(Object obj){
        String operationName = checkOperation((String) obj);
        return Builder.buildInput(((String) obj).split("\\s+") , operationName);
    }



}
