package com.example.demo.Controller.Bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UpdateSubmissionInput implements Serializable {

    String id;
    String companyName;
    String addressName;
    Integer annualRevenue;
}
