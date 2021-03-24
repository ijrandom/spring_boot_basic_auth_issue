package com.example.basic_auth_issue;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrivateApiController {

    @GetMapping("/private/hello")
    public String hello() {
        return "hi";
    }
}
