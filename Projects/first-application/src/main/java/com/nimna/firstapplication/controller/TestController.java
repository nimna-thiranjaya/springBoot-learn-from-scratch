package com.nimna.firstapplication.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Annotate this class as controller
@CrossOrigin //CrossOrigin - this use for security. using this we can accept only request coming from specific address "@CrossOrigin("http://localhost:3000")"
@RequestMapping("api/v1/test") //this is the unique identifier of the controller
public class TestController {
    @GetMapping(path = "/get-name") //endpoint identifier
    public void getMyText (){
        String myText = "My Name Is Nimna";

        System.out.println(myText);
    }

    @GetMapping (path = "/get-age")//endpoint identifier
    public void getMySecondText (){
        String myText = "My age is 23";

        System.out.println(myText);
    }

    @GetMapping(path = "/get-school")
    public String getSchool() {
        String schoolName = "Galahitiyawa Central College";
        return schoolName;
    }
}
