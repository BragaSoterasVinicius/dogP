package com.soter.dogp.controller;

import com.soter.dogp.objcts.Posts;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StartPageController {
    @GetMapping("/")
    public String posteLoader(HttpSession session, Model model){
        if(session.getAttribute("USERID") != null){
            return "redirect:/poste";
        }
        return "startpage";
    }
}
