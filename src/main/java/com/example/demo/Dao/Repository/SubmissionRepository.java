package com.example.demo.Dao.Repository;

import com.example.demo.Dao.Model.Submission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepository extends CrudRepository<Submission,String> {

    Submission findByCompanyNameAndAddressName(String companyName , String addressName);
}
