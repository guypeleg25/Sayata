package com.example.demo.Controller.Bo;

import com.example.demo.Dao.Model.Submission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSubmissionOutput {

    String msg;
    Submission submission;
}
