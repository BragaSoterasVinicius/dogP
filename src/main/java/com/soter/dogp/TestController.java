package com.soter.dogp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
