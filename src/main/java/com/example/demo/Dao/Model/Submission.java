package com.example.demo.Dao.Model;

import com.example.demo.Util.SubmissionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Table(name = "submission")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    String companyName;
    String addressName;
    Integer annualRevenue;
    Enum status = SubmissionStatus.newSubmission;
    //TODO sign

    public Submission(String companyName,String addressName, Integer annualRevenue){
        this.setCompanyName(companyName);
        this.setAddressName(addressName);
        this.setAnnualRevenue(annualRevenue);
    }

}
