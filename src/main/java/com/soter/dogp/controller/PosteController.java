package com.soter.dogp.controller;

import com.soter.dogp.objcts.PersonalPost;
import com.soter.dogp.objcts.Posts;
import com.soter.dogp.objcts.User;
import com.soter.dogp.service.DogService;
import com.soter.dogp.service.PostService;
import com.soter.dogp.service.UserService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PosteController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;
    @Autowired
    private DogService dogService;
    @Autowired
    private ImageController imageController;
    @GetMapping("/poste")
    public String posteLoader(HttpSession session, Model model){
        Integer posteId = (Integer)session.getAttribute("POSTEID");
        String email = (String)session.getAttribute("USEREMAIL");
        String name = (String)session.getAttribute("USERNAME");
        Integer userid = (Integer)session.getAttribute("USERID");
        userService.setUserLastPoste(posteId, email);
        dogService.getImagesByPosteId(posteId);
        List<Posts> posts = postService.getPostsByPoste(posteId);
        List<PersonalPost> personalPosts = postService.buildPersonalPosts(posts, session);
        List<String> dogGallery = dogService.getImagesByPosteId(posteId);
        model.addAttribute("userid", userid);
        model.addAttribute("posteId", posteId);
        model.addAttribute("username", name);
        model.addAttribute("listsPosts", personalPosts);
        model.addAttribute("dogGallery", dogGallery);
        return "feed";
    }

    @PostMapping ("/postar")
    public String postar(HttpSession session, Model model, @ModelAttribute("Posts") Posts newPosts){
        model.addAttribute("postModel", new Posts());
        Integer user_id = (Integer) session.getAttribute("USERID");
        String post = newPosts.getPost();
        Integer posteId = (Integer) session.getAttribute("POSTEID");
        postService.makePost(user_id, post, posteId);
        return "redirect:/poste";
    }

    @GetMapping("/nextPoste")
    public String nextPoste(HttpSession session, Model model){
        Integer rnPoste = (Integer) session.getAttribute("POSTEID");
        session.setAttribute("POSTEID",rnPoste+1);
        return "redirect:/poste";
    }
    @GetMapping("/lastPoste")
    public String lastPoste(HttpSession session, Model model){
        Integer rnPoste = (Integer) session.getAttribute("POSTEID");
        if(rnPoste > 0){
            session.setAttribute("POSTEID",rnPoste-1);
        }
        return "redirect:/poste";
    }
    @GetMapping("/jumpTo")
    public String jumpTo(HttpSession session, Model model, @ModelAttribute("Posts") Posts postePage){
        Integer pageJump = postePage.getPosteId();
        session.setAttribute("POSTEID",pageJump);
        return "redirect:/poste";
    }

}
