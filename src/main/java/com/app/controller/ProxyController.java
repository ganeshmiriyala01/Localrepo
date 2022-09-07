package com.app.controller;

import com.app.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class ProxyController {



    @GetMapping(path = "/", produces = "application/json")
    public ResponseEntity<Object> proxy(){

        WebClient webClient = WebClient.create("https://jsonplaceholder.typicode.com");
       Object s =  webClient.get()
                .uri("/todos/1")
                .retrieve()
               .bodyToMono(String.class)
               .block();

       return new ResponseEntity<>(s.toString(), HttpStatus.ACCEPTED);


    }
    @PostMapping(path = "/AuthUserClientCredentials", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> check(@RequestBody RequestBodyModel request) throws JsonProcessingException {
//        RequestBody bodyData = new RequestBody("cru", "cru_service", "Lexis2013","CRUORDPT","cru_ops");
        WebClient webClient = WebClient.create("https://mbswsdev.risk.regn.net");
        TokenModel s = webClient
                .post()
                .uri("/LNAA/LNAAv10/AuthUserClientCredentials")
                .body(BodyInserters.fromValue(request))
                .retrieve()
                .bodyToMono(TokenModel.class)
                .block();
        try {
            s.setStatus(new StatusModel(0, "LoginSuccess"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        s.setToken(s.getAccess_token());

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

            String json = ow.writeValueAsString(s);

        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @PostMapping(path = "/AuthUser", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> getLdap(@RequestBody LDAPRequestBodyModel request) throws JsonProcessingException {
        WebClient webClient = WebClient.create("https://mbswsdev.risk.regn.net");
        System.out.println(request);
        LDAPModel s = webClient
                .post()
                .uri("/LNAA/LNAAv10/AuthUser")
                .body(BodyInserters.fromValue(request))
                .retrieve()
                .bodyToMono(LDAPModel.class)
                .block();
        try {
            System.out.println(s);
//            s.setStatus(new StatusModel(0, "LoginSuccess"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        String json = ow.writeValueAsString(s);

        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @PostMapping(path = "/AdminGetUserData", produces = "application/json")
    public ResponseEntity<Object> getAdminUserData(@RequestBody SecondAuthModel secondAuthModel) {
        System.out.println(secondAuthModel);
        Map<String,Map<String,String>> workstation = new HashMap<>();
        Map<String,String> workstation_session = new HashMap<>();
        Map<String,String> workstation_login = new HashMap<>();
        workstation_session.put("session_id", secondAuthModel.getSession_id());
        workstation_login.put("login_id", secondAuthModel.getLogin_id());
        workstation.put("session", workstation_session);
        workstation.put("data",workstation_login);
        WebClient webClient = WebClient.create("https://mbswsdev.risk.regn.net");
                Object s = webClient
                .post()
                .uri("/LNAA/LNAAv10/AdminGetUserData")
                .body(BodyInserters.fromValue(workstation))
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

//    @PostMapping(path = "/AdminGetUserData", produces = "application/json", consumes = "application/json")
//    public ResponseEntity<Object> getAdminUserData(@RequestBody AdminRequestBodyModel request) throws JsonProcessingException {
//        WebClient webClient = WebClient.create("https://mbswsdev.risk.regn.net");
//        System.out.println(request);
//        LDAPModel s = webClient
//                .post()
//                .uri("/LNAA/LNAAv10/AdminGetUserData")
//                .body(BodyInserters.fromValue(request))
//                .retrieve()
//                .bodyToMono(LDAPModel.class)
//                .block();
//        try {
//            System.out.println(s);
////            s.setStatus(new StatusModel(0, "LoginSuccess"));
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//
//        String json = ow.writeValueAsString(s);
//
//        return new ResponseEntity<>(json, HttpStatus.OK);
//    }
}


