package com.example.demo.Util;
import org.springframework.web.client.RestTemplate;

public class CallOperation {

    public static Object callAPI(String operationName , Object input)   {

        RestTemplate restTemplate = new RestTemplate();
        String urlOperation = Constants.mapFromOperationNameToAPI.get(operationName);
        switch(operationName){

            case "create": case "update": case "bind": case "login" : case "register":
                return restTemplate.postForObject(urlOperation,input,String.class);

            case "get": case "annualRevenue":
            return restTemplate.getForObject(urlOperation + input,String.class);

            case "list":
                return restTemplate.getForObject(urlOperation,String.class);


        }
        return restTemplate;
    }

}
