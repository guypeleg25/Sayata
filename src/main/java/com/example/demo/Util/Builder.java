package com.example.demo.Util;

import com.example.demo.Controller.Bo.BindSubmissionInput;
import com.example.demo.Controller.Bo.CreateSubmissionInput;
import com.example.demo.Controller.Bo.UpdateSubmissionInput;
import com.example.demo.Dao.Model.Submission;
import com.example.demo.Dao.Model.User;

public class Builder {

    public static Object buildInput(String[] values , String operationName){
        String inputName = Constants.mapFromOperationNameToInputClass.get(operationName);
            switch (inputName) {
                case "CreateSubmissionInput":
                    return CreateSubmissionInput.builder().
                            companyName(values[2]).addressName(values[3]).annualRevenue(Integer.valueOf(values[4])).build();
                case "UpdateSubmissionInput":
                    return UpdateSubmissionInput.builder().
                            id(values[2]).companyName(values[3]).addressName(values[4]).annualRevenue(Integer.valueOf(values[5])).build();
                case "GetSubmission":
                    return values[2];

                case "BindSubmissionInput":
                    return BindSubmissionInput.builder().
                            id(values[2]).signedApplicationPath(values[3]).build();
                case "ListSubmission":
                    return values;

                case "User": case "Register":
                    return User.builder().id(values[1]).password(values[2]).build();

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
