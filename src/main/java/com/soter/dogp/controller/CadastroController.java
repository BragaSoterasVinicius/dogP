package com.soter.dogp.controller;

import com.soter.dogp.objcts.User;
import com.soter.dogp.repo.UserRepo;
import com.soter.dogp.service.CadastroService;
import com.soter.dogp.service.SessionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CadastroController {

    @Autowired
    CadastroService cadastroService;

    @Autowired
    SessionService sessionService;
    @GetMapping("/cadastro")
    public String cadastroPage(Model model, @ModelAttribute("User") User userCadastro){
        return "cadastro";
    }

    @GetMapping ("/cadastrar")
    public String cadastroNewUser(HttpSession session, Model model, @ModelAttribute("User") User userCadastro){
        model.addAttribute("cadastroModel", new User());
        String nome = userCadastro.getNome();
        String email = userCadastro.getEmail();
        String senha = userCadastro.getSenha();
        cadastroService.saveUser(nome, email, senha);
        sessionService.setUserSession(session, userCadastro);
        return "redirect:/poste";
    }
}
