package com.nimna.springsecurity.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notice")
@CrossOrigin
public class NoticeController {
    @GetMapping(path = "my-notice")
    public String getNoticeDetails(){
        return "My Notices";
    }
}
