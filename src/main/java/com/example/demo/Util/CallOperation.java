package com.example.demo.Util;
import org.springframework.web.client.RestTemplate;

public class CallOperation {

    public static Object callAPI(String operationName , Object input)   {

        RestTemplate restTemplate = new RestTemplate();
        String urlOperation = Constants.mapFromOperationNameToAPI.get(operationName);
        switch(operationName){
            case "create": case "update": case "bind":
                return restTemplate.postForObject(urlOperation,input,String.class);

            case "get":
            return restTemplate.getForObject(urlOperation + input,String.class);

            case "list":
                return restTemplate.getForObject(urlOperation,String.class);
        }
        return restTemplate;
    }

}
