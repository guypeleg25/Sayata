package com.example.demo.Service;

import com.example.demo.Controller.Bo.*;


public interface Service {

    CreateSubmissionOutput createSubmission(CreateSubmissionInput createSubmissionInput);
    String updateSubmission (UpdateSubmissionInput updateSubmissionInput);
    GetSubmissionOutput getSubmission (String id);
    String bindSubmission(BindSubmissionInput bindSubmissionInput);
    GetListOnlyBoundOutput getListOnlyBound();
}