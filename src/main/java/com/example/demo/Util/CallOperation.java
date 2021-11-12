package com.example.demo.Util;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;

public class CallOperation {

    public static Object callAPI(String string , Object input) throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();
        URIBuilder uriBuilder = new URIBuilder(Constants.URL);
        switch(string){
            case "create":
                uriBuilder.setPath("createSubmission");
                return restTemplate.postForObject(uriBuilder.toString(),input,String.class);

            case "update":
                uriBuilder.setPath("updateSubmission");
                return restTemplate.postForObject(uriBuilder.toString(),input,String.class);

            case "get":
            uriBuilder.setPath("getSubmission" + "/" + input);
            return restTemplate.getForObject(uriBuilder.toString(),String.class);

            case "bind":
                uriBuilder.setPath("bindSubmission");
                return restTemplate.postForObject(uriBuilder.toString(),input,String.class);

            case "list": uriBuilder.setPath("getListOnlyBound");
                return restTemplate.getForObject(uriBuilder.toString(),String.class);
        }
        return null;
    }

}
