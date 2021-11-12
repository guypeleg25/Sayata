package com.example.demo.Controller.Bo;

import com.example.demo.Dao.Model.Submission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class GetListOnlyBoundOutput {

    String msg;
    List<Submission> submissionList;
}
