package com.example.demo.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class Controller {

    @RequestMapping(method = RequestMethod.POST)
    public void home(String string) {
        System.out.println(string);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/createSubmission")
    public void createSubmission(String s) {
        System.out.println("I am createSubmission");
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/updateSubmission")
    public void updateSubmission() {
        System.out.println("I am updateSubmission");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getSubmission/{id}")
    public void getSubmission(@PathVariable(value = "id") Integer id) {
    }

    //TODO bind


}