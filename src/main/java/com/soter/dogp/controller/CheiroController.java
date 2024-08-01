package com.soter.dogp.controller;

import com.soter.dogp.objcts.Cheiro;
import com.soter.dogp.objcts.Posts;
import com.soter.dogp.service.SmellService;
import jakarta.persistence.Column;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CheiroController {

    @Autowired
    SmellService smellService;

    @PostMapping ("/addSmell")
    public String addSmell(Model model, HttpSession session, @ModelAttribute("Cheiro") Cheiro newCheiro){
        model.addAttribute("cheiroModel", new Cheiro());
        Integer cheirado = newCheiro.getCheirado_id();
        smellService.addCheiroToMemory(session, cheirado);
        return "redirect:/poste";
    }
}
