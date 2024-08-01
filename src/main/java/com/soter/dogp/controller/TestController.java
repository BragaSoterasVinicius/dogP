package com.soter.dogp.controller;

import com.soter.dogp.objcts.Posts;
import com.soter.dogp.objcts.User;
import com.soter.dogp.repo.PostRepo;
import com.soter.dogp.repo.UserRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//aqui vai ser a nossa classezinha de debogagem, vai ser apagado em prod confia
@RestController
public class TestController {

    private PostRepo postRepo;
    private UserRepo userRepo;

    public TestController(PostRepo postRepo, UserRepo userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }
    private final String HOME_VIEW_COUNT = "HOME_VIEW_COUNT";
    @GetMapping("/teste")
    public String postRepoTeste(HttpSession session){
        incrementCount(session, HOME_VIEW_COUNT);
        Object userid = session.getAttribute("USERID");
        System.out.println(userid);
        Object username = session.getAttribute("USERNAME");
        System.out.println(username);
        Object useremail = session.getAttribute("USEREMAIL");
        System.out.println(useremail);
        Object logged = session.getAttribute("LOGGED");
        System.out.println(logged);
        return "testeDiferente, " + session.getAttribute(HOME_VIEW_COUNT) + ", user" + userid ;
    }

    @GetMapping("/count")
    public String count(HttpSession session){
        return "HOME_VIEW_COUNT: " +session.getAttribute(HOME_VIEW_COUNT);
    }

    private void incrementCount(HttpSession session, String attr) {
        var homeViewCount = session.getAttribute(attr) == null ? 0 : (Integer) session.getAttribute(attr);
        session.setAttribute(attr, homeViewCount += 1);
    }
}
