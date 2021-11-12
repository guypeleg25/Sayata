package com.example.demo.Util;

import java.util.HashMap;

public class Constants {

    public static final String SERVER_IP = "127.0.0.1";
    public static final Integer SERVER_PORT = 8000;
    public static String URL = "http://localhost:8080/";

    public static HashMap<String, String> mapFromOperationNameToInputClass = new HashMap<>();
    static {
        mapFromOperationNameToInputClass.put("create" , "CreateSubmissionInput");
        mapFromOperationNameToInputClass.put("update" , "UpdateSubmissionInput");
        mapFromOperationNameToInputClass.put("bind" , "BindSubmissionInput");
        mapFromOperationNameToInputClass.put("get" , "GetSubMission");
    }
    public static HashMap<String, String> mapFromOperationNameToAPI = new HashMap<>();
    static {
        mapFromOperationNameToAPI.put("create" , URL+"createSubmission");
        mapFromOperationNameToAPI.put("update" , URL+"updateSubmission");
        mapFromOperationNameToAPI.put("get" , URL+"getSubmission/");
        mapFromOperationNameToAPI.put("bind" , URL+"bindSubmission");
        mapFromOperationNameToAPI.put("list" , URL+"getListOnlyBound");
    }
}
