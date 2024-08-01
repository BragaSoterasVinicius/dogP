package com.soter.dogp.controller;

import com.soter.dogp.objcts.Posts;
import com.soter.dogp.service.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PosteController {

    @Autowired
    private PostService postService;
    @GetMapping("/poste/{posteId}")
    public String posteLoader(@PathVariable Integer posteId, Model model){
        List<Posts> posts = postService.getPostsByPoste(posteId);
        model.addAttribute("posteId", posteId);
        model.addAttribute("listsPosts", posts);
        return "feed";
    }
}
