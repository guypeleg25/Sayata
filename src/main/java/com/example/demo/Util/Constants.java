package com.example.demo.Util;

import java.util.HashMap;

public class Constants {

    //TODO use this class in the code
    public static final String SERVER_IP = "127.0.0.1";
    public static final Integer SERVER_PORT = 8000;
    public static String URL = "http://localhost:8080/";
    public static HashMap<String,String> mapOperationNameToInputClass = new HashMap<>();

    public static HashMap<String, String> getMapOperationNameToInputClass() {
        mapOperationNameToInputClass.put("create" , "CreateSubmissionInput");
        mapOperationNameToInputClass.put("update" , "UpdateSubmissionInput");
        mapOperationNameToInputClass.put("bind" , "BindSubmissionInput");
        mapOperationNameToInputClass.put("get" , "GetSubMission");
        return mapOperationNameToInputClass;
    }
}
