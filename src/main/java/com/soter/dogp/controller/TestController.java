package com.soter.dogp.controller;

import com.soter.dogp.repo.PostRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    private PostRepo postRepo;

    public TestController(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @GetMapping("/")
    public String mainPage(){
        return "teste";
    }
}
