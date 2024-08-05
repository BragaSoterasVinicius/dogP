package com.soter.dogp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DogDrawController {
    @GetMapping("/draw")
    public String drawLoader(){
        return "dogDraw";
    }
}
