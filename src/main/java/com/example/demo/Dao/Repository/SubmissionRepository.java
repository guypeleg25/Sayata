package com.example.demo.Dao.Repository;

import com.example.demo.Dao.Model.Submission;
import com.example.demo.Util.SubmissionStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends CrudRepository<Submission,String> {

    Submission findByCompanyNameAndAddressName(String companyName , String addressName);
    List<Submission> findByStatus(SubmissionStatus status);
}
