package com.example.demo.Controller;

import com.example.demo.Controller.Bo.CreateSubmissionInput;
import com.example.demo.Controller.Bo.CreateSubmissionOutput;
import com.example.demo.Controller.Bo.UpdateSubmissionInput;
import com.example.demo.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class Controller {

    @Autowired
    Service service;

//    @RequestMapping(method = RequestMethod.POST)
//    public void home(String string) {
//        System.out.println(string);
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/createSubmission")
    public CreateSubmissionOutput createSubmission(@RequestBody CreateSubmissionInput createSubmissionInput) {
        System.out.println("createSubmission was activated");
        return service.createSubmission(createSubmissionInput);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/updateSubmission")
    public String updateSubmission(@RequestBody UpdateSubmissionInput updateSubmissionInput) {
        System.out.println("updateSubmission was activated");
        return service.updateSubmission(updateSubmissionInput);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getSubmission/{id}")
    public void getSubmission(@PathVariable(value = "id") String id) {
        System.out.println("getSubmission was activated");
        service.getSubmission(id);
    }

    //TODO bind


}