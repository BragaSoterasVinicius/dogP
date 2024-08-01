package com.soter.dogp.service;

import com.soter.dogp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {

    @Autowired
    private UserRepo userRepo;

    public void saveUser(String nome, String email, String senha){
        if(doesUserNotExists(email)){
            saveUserToBd(nome, email, senha);
        }
    }
    public boolean doesUserNotExists(String email){
        return userRepo.searchForUserSenha(email)== null;
    }
    public void saveUserToBd(String nome, String email, String senha){
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encodedSenha = bcrypt.encode(senha);
        userRepo.saveNewUser(nome, email, encodedSenha);
    }
}
