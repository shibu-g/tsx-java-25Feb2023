package com.example.demo;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class UserService {

    Logger l= LoggerFactory.getLogger(UserService.class);
    public String getCommit(String str){
        l.info(str);
        return str;
    }
    public String getallcommis() throws IOException, InterruptedException {
        //github api call link
        var url="https://api.github.com/repos/shibu-g/dummy-github-events/commits";


        //http request
        var req= HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

        //http client
        var cli = HttpClient.newBuilder().build();

        //responce after call github api
        var res=cli.send(req, HttpResponse.BodyHandlers.ofString());


        l.info(res.body());
        return res.body();
    }
}
