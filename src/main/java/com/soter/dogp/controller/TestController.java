package com.soter.dogp.controller;

import com.soter.dogp.objcts.Posts;
import com.soter.dogp.objcts.User;
import com.soter.dogp.repo.PostRepo;
import com.soter.dogp.repo.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestController {

    private PostRepo postRepo;
    private UserRepo userRepo;

    public TestController(PostRepo postRepo, UserRepo userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/repoTest")
    public String postRepoTeste(){

        User alberto = userRepo.getUserDataByUserId(4);
        System.out.println(alberto.getNome());
        return "teste";
    }
}
