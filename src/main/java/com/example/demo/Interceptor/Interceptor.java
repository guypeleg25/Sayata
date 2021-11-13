package com.example.demo.Interceptor;

import com.example.demo.Util.Builder;
import com.example.demo.Util.CallOperation;


public class Interceptor {

    public static String getOperationName(String string) {
        if (string.contains(" ")) {
            string = string.substring(0, string.indexOf(" "));
        }
        return string;

    }

    public static Object parse(Object obj) {
        String operationName = getOperationName((String) obj);
        Object input = Builder.buildInput(((String) obj).split("\\s+") , operationName);
        if(input == null) return "The Interceptor does not know this operation";
        return CallOperation.callAPI(operationName,input);
    }

}
