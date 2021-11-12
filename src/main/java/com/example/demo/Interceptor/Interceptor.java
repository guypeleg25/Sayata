package com.example.demo.Interceptor;

import com.example.demo.Util.Builder;
import com.example.demo.Util.CallOperation;

import java.net.URISyntaxException;

public class Interceptor {

    public static String getOperationName(String string) {
        if (string.contains(" ")) {
            string = string.substring(0, string.indexOf(" "));
        }
        return string;

    }

    public static Object parse(Object obj) throws URISyntaxException {
        String operationName = getOperationName((String) obj);
        Object input = Builder.buildInput(((String) obj).split("\\s+") , operationName);
        return CallOperation.callAPI(operationName,input);
    }

}
