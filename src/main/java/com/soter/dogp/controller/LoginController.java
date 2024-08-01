package com.soter.dogp.controller;

import com.soter.dogp.objcts.User;
import com.soter.dogp.repo.UserRepo;
import com.soter.dogp.service.LoginService;
import com.soter.dogp.service.SessionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    SessionService sessionService;

    @Autowired
    private UserRepo userRepo;
    @GetMapping("/login")
    public String loginPage(Model model, @ModelAttribute("User") User userLogin){
        return "login";
    }
    @GetMapping("/logar")
    public String login(HttpSession session, Model model, @ModelAttribute("User") User userLogin){
        model.addAttribute("loginModel", new User());
        String email = userLogin.getEmail();
        String senha = userLogin.getSenha();
        boolean logincerto = loginService.auth(email, senha);
        if(logincerto){
            User user = userRepo.getUserDataByEmail(email);
            sessionService.setUserSession(session, user);
        }
        return "redirect:/poste";
    }
}
