package com.example.demo.Service;

import com.example.demo.Controller.Bo.CreateSubmissionInput;
import com.example.demo.Controller.Bo.CreateSubmissionOutput;
import com.example.demo.Controller.Bo.UpdateSubmissionInput;
import com.example.demo.Dao.Model.Submission;
import com.example.demo.Dao.Repository.SubmissionRepository;
import com.example.demo.ExistsExp;
import com.example.demo.Util.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{

    @Autowired
    SubmissionRepository submissionRepository;

    @Override
    public CreateSubmissionOutput createSubmission(CreateSubmissionInput createSubmissionInput) {

        Submission submission = submissionRepository.findByCompanyNameAndAddressName(createSubmissionInput.getCompanyName(),createSubmissionInput.getAddressName());
        if(!ObjectUtils.isEmpty(submission)){
            throw new ExistsExp(ServiceImpl.class.getName(), "The Submission is exists");
        }
        Submission s = submissionRepository.save(Builder.buildSubmission(createSubmissionInput));
        return CreateSubmissionOutput.builder().id(s.getId()).msg("Submission is saved").build();
    }

    @Override
    public String updateSubmission(UpdateSubmissionInput updateSubmissionInput) {

        List<Submission> list = (List<Submission>) submissionRepository.findAll();
        System.out.println(list);
        Optional<Submission> submission = submissionRepository.findById(updateSubmissionInput.getId());
        if(ObjectUtils.isEmpty(submission.get())){
            throw new ExistsExp(ServiceImpl.class.getName(), "The Submission is exists");
        }
        else{
            submission.get().setCompanyName(updateSubmissionInput.getCompanyName());
            submission.get().setAddressName(updateSubmissionInput.getCompanyName());
            submission.get().setAnnualRevenue(updateSubmissionInput.getAnnualRevenue());
            submissionRepository.save(submission.get());
            return "Successes update";
        }
    }

    @Override
    public void getSubmission(String id) {
        //TODO add bind logic
        Optional<Submission> submission = submissionRepository.findById(id);
        if(ObjectUtils.isEmpty(submission.get())){
            throw new ExistsExp(ServiceImpl.class.getName(), "The Submission is not exists");
        }
        else{
            //RETURN SUB
        }

    }
}
