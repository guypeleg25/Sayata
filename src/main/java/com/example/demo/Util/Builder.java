package com.example.demo.Util;

import com.example.demo.Controller.Bo.CreateSubmissionInput;
import com.example.demo.Dao.Model.Submission;

import java.util.HashMap;

public class Builder {


    static HashMap<String,String> map = new HashMap<>();
    public static CreateSubmissionInput buildCreate(String[] values){
        return CreateSubmissionInput.builder().
                companyName(values[0]).addressName(values[1]).annualRevenue(Integer.valueOf(values[2])).build();
    }

    public static Object buildInput(String[] values , String operationName){
        map.put("create", "CreateSubmissionInput");
        String inputName = map.get(operationName);
        if(inputName.equals("CreateSubmissionInput")){
            return CreateSubmissionInput.builder().
                    companyName(values[2]).addressName(values[3]).annualRevenue(Integer.valueOf(values[4])).build();
        }


        return null;
    }
    public static Submission buildSubmission(CreateSubmissionInput createSubmissionInput){
        return Submission.builder().companyName(createSubmissionInput.getCompanyName()).
                addressName(createSubmissionInput.getAddressName()).
                annualRevenue(createSubmissionInput.getAnnualRevenue()).
                build();

    }
}
