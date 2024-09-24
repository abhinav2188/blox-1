package com.example.blox.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CallMeService {

    public ResponseEntity<String> callMe(String userName){
        String body = "Api called by "+ userName;
        return ResponseEntity.ok().body(body);
    }

}
