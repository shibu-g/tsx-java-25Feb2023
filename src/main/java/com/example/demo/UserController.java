package com.example.demo;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Builder;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.*;
import java.io.*;

import java.util.ArrayList;

@RestController
public class UserController {

    @Autowired
    UserService service;
    Logger l = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/get")
    public String get() {

        l.info("inside user controller class ");
        return "Success";
    }

    @PostMapping("/webhook")
    public ResponseEntity<String> getCommits(@RequestBody String s) {
        String newstr = "";

        try {
            newstr = service.getCommit(s);
        } catch (Exception e) {
            l.info(e.toString());
        }
        return new ResponseEntity<String>(newstr, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getallcommits")
    public ResponseEntity<String> getallcommis() throws IOException, InterruptedException {
        String newstr = "";
        try {
            newstr = service.getallcommis();
        } catch (Exception e) {
            l.info(e.toString());
        }
        return new ResponseEntity<String>(newstr, HttpStatus.ACCEPTED);
    }
}
