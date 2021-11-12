package com.example.demo.Controller;

import com.example.demo.Controller.Bo.*;
import com.example.demo.Dao.Model.User;
import com.example.demo.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {

    @Autowired
    Service service;

    @RequestMapping(method = RequestMethod.POST, value = "/createSubmission")
    public CreateSubmissionOutput createSubmission(@RequestBody CreateSubmissionInput createSubmissionInput) {
        System.out.println("createSubmission was activated");
        return service.createSubmission(createSubmissionInput);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateSubmission")
    public String updateSubmission(@RequestBody UpdateSubmissionInput updateSubmissionInput) {
        System.out.println("updateSubmission was activated");
        return service.updateSubmission(updateSubmissionInput);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getSubmission/{id}")
    public GetSubmissionOutput getSubmission(@PathVariable(value = "id") String id) {
        System.out.println("getSubmission was activated");
        return service.getSubmission(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/bindSubmission")
    public String bindSubmission(@RequestBody BindSubmissionInput bindSubmissionInput){
        System.out.println("bindSubmission was activated");
        return service.bindSubmission(bindSubmissionInput);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getListOnlyBound")
    public GetListOnlyBoundOutput getListOnlyBound(){
        System.out.println("getListOnlyBound was activated");
        return service.getListOnlyBound();
    }


    @RequestMapping(method = RequestMethod.POST, value = "/registerUser")
    public String registerUser(@RequestBody User user){
        System.out.println("registerUser was activated");
        return  service.registerUser(user);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(@RequestBody User user){
        System.out.println("login was activated");
        return service.login(user);
    }
}