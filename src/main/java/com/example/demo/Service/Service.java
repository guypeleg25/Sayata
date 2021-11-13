package com.example.demo.Service;

import com.example.demo.Controller.Bo.*;
import com.example.demo.Dao.Model.Submission;
import com.example.demo.Dao.Model.User;

import java.util.List;


public interface Service {

    CreateSubmissionOutput createSubmission(CreateSubmissionInput createSubmissionInput);
    String updateSubmission (UpdateSubmissionInput updateSubmissionInput);
    GetSubmissionOutput getSubmission (String id);
    String bindSubmission(BindSubmissionInput bindSubmissionInput);
    GetListOnlyBoundOutput getListOnlyBound();
    String registerUser(User user);
    String login(User user);
    List<Submission> getListByAnnualRevenue(Integer annualRevenue);
}