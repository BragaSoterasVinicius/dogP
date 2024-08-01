package com.soter.dogp.controller;

import com.soter.dogp.objcts.User;
import com.soter.dogp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public String loginPage(Model model, @ModelAttribute("User") User userLogin){
        return "login";
    }
    @GetMapping("/logar")
    public String login(Model model, @ModelAttribute("User") User userLogin){
        model.addAttribute("loginModel", new User());
        String email = userLogin.getEmail();
        String senha = userLogin.getSenha();
        boolean logincerto = loginService.auth(email, senha);
        System.out.print(logincerto);
        return "login";
    }
}
