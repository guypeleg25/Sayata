package com.example.demo.Service;

import com.example.demo.Controller.Bo.*;
import com.example.demo.Dao.Model.User;


public interface Service {

    CreateSubmissionOutput createSubmission(CreateSubmissionInput createSubmissionInput);
    String updateSubmission (UpdateSubmissionInput updateSubmissionInput);
    GetSubmissionOutput getSubmission (String id);
    String bindSubmission(BindSubmissionInput bindSubmissionInput);
    GetListOnlyBoundOutput getListOnlyBound();
    String registerUser(User user);
    String login(User user);
}