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

    @Autowired
    private Utils utils;

    @ControllerAdvice(RateLimiterAccquireException.class)
    public ResponseEntity<String> return429(Exception e){
        return ResponseEntity.statusCode(429).body(e.getMessage);

    }


    @GetMapping
    public ResponseEntity<String> callMe(@RequestParam String userName){
        
        // check whether api call allowed or not
        if(utils.isApiCallAllowed()){
            // return api response
            return callMeService.callMe(userName);
        }else{
            // if api call is not allowed, we need to increase eeeeeeeeeeeee
        }
 
    }

}
