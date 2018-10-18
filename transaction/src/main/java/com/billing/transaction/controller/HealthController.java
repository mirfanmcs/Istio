package com.billing.transaction.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class HealthController {


    @GetMapping(path="/health")
    public ResponseEntity get() {
        return new ResponseEntity(HttpStatus.OK);
    }
}
