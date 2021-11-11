package com.example.demo.Service;

import com.example.demo.Controller.Bo.CreateSubmissionInput;
import com.example.demo.Controller.Bo.CreateSubmissionOutput;
import com.example.demo.Controller.Bo.UpdateSubmissionInput;

public interface Service {

    CreateSubmissionOutput createSubmission(CreateSubmissionInput createSubmissionInput);
    String updateSubmission (UpdateSubmissionInput updateSubmissionInput);
    void getSubmission (String id);
}