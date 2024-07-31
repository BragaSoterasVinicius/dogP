package com.soter.dogp.service;

import com.soter.dogp.repo.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Objects;

public class LoginService {
    private UserRepo userRepo;
    public boolean auth(String email, String senha){
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encodedSenha = bcrypt.encode(senha);
        String senhaOnDb = userRepo.searchForUserSenha(email);
        if (Objects.equals(encodedSenha, senhaOnDb)){
            return true;
        }else{
            return false;
        }
    }
}
