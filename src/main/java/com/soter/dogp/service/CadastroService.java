package com.soter.dogp.service;

import com.soter.dogp.repo.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {
    private UserRepo userRepo;
    public boolean doesUserExists(String email){
        //Com certeza deve dar pra só retornar essa condicional, vou fazer isso logo logo
        if(userRepo.searchForUserSenha(email)!= null){
            return true;
        }else{
            return false;
        }
    }
    public void saveUser(String nome, String email, String senha){
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encodedSenha = bcrypt.encode(senha);
        userRepo.saveNewUser(nome, email, encodedSenha);
    }
}
