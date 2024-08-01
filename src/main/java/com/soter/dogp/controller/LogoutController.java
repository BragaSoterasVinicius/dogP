package com.soter.dogp.controller;

import com.soter.dogp.service.SessionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
    @Autowired
    SessionService sessionService;
    @GetMapping("/logout")
    public String logOut(HttpSession session){
        sessionService.destroyUserSession(session);
        return "startpage";
    }
}
