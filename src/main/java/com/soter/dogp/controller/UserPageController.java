package com.soter.dogp.controller;

import com.soter.dogp.objcts.Posts;
import com.soter.dogp.service.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserPageController {

    @Autowired
    private PostService postService;

    @GetMapping("/perfil")
    public String perfil(HttpSession session, Model model){
        String name = (String) session.getAttribute("USERNAME");
        Integer user_id = (Integer)session.getAttribute("USERID");
        List<Posts> listMyPosts = postService.getPostsByUserId(user_id);
        model.addAttribute("username", name);
        model.addAttribute("listsPosts", listMyPosts);
        return "userPage";
    }
}
