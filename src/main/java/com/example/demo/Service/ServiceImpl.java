package com.example.demo.Service;

import com.example.demo.Controller.Bo.*;
import com.example.demo.Dao.Model.Submission;
import com.example.demo.Dao.Repository.SubmissionRepository;
import com.example.demo.Util.Builder;
import com.example.demo.Util.SubmissionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{

    @Autowired
    SubmissionRepository submissionRepository;

    @Override
    public CreateSubmissionOutput createSubmission(CreateSubmissionInput createSubmissionInput) {

        Submission submission = submissionRepository.findByCompanyNameAndAddressName(createSubmissionInput.getCompanyName(),
                createSubmissionInput.getAddressName());
        if(!ObjectUtils.isEmpty(submission)){
            return CreateSubmissionOutput.builder().msg("Submission is exits with the parameters").build();
        }
        Submission s = submissionRepository.save(Builder.buildSubmission(createSubmissionInput));
        return CreateSubmissionOutput.builder().id(s.getId()).msg("Submission is saved").build();
    }

    @Override
    public String updateSubmission(UpdateSubmissionInput updateSubmissionInput) {

        Submission submission = checkIfTheSubmissionExistsById(updateSubmissionInput.getId());
        if(ObjectUtils.isEmpty(submission)){
           return "Didn't find the submission with id " + updateSubmissionInput.getId();
        }
            submission.setCompanyName(updateSubmissionInput.getCompanyName());
            submission.setAddressName(updateSubmissionInput.getCompanyName());
            submission.setAnnualRevenue(updateSubmissionInput.getAnnualRevenue());
            submissionRepository.save(submission);
            return "Successes update";
    }

    @Override
    public GetSubmissionOutput getSubmission(String id) {
        Submission submission = checkIfTheSubmissionExistsById(id);
        if(ObjectUtils.isEmpty(submission)){
            return GetSubmissionOutput.builder().msg("The submission id does not exits").build();
        }
            return GetSubmissionOutput.builder().msg("Successes to get the submission").submission(submission).build();
    }

    @Override
    public String bindSubmission(BindSubmissionInput bindSubmissionInput) {
        Submission submission = checkIfTheSubmissionExistsById(bindSubmissionInput.getId());
        submission.setSignedApplicationPath(bindSubmissionInput.getSignedApplicationPath());
        submission.setStatus(SubmissionStatus.boundSubmission);
        submissionRepository.save(submission);

        return "Successes bindSubmission";
    }

    @Override
    public GetListOnlyBoundOutput getListOnlyBound() {

        List<Submission> submissionList = submissionRepository.findByStatus(SubmissionStatus.boundSubmission);
        if(ObjectUtils.isEmpty(submissionList)){
            return GetListOnlyBoundOutput.builder().msg("There is no submission with bound status").build();
        }
        return GetListOnlyBoundOutput.builder().msg("Successes return bound list").submissionList(submissionList).build();
    }

    private Submission checkIfTheSubmissionExistsById(String id){

        Optional<Submission> submission = submissionRepository.findById(id);
        if(!submission.isPresent() || submission.isEmpty()){
            return null;
        }
        return submission.get();
    }
}
