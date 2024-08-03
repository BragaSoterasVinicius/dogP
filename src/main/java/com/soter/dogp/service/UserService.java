package com.soter.dogp.service;

import com.soter.dogp.repo.PostRepo;
import com.soter.dogp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void setUserLastPoste(Integer newLastPoste, String userEmail){
        userRepo.alterLastPost(newLastPoste, userEmail);

    }

}
