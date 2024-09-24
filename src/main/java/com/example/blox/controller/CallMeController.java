package com.example.blox.controller;

import com.example.blox.Service.CallMeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallMeController {

    @Autowired
    private CallMeService callMeService;

    @GetMapping
    public ResponseEntity<String> callMe(@RequestParam String userName){
        // check whether api call allowed or not
        // return api response
        return callMeService.callMe(userName);
    }

}
