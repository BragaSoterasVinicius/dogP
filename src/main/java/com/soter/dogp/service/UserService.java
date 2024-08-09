package com.soter.dogp.service;

import com.soter.dogp.repo.PostRepo;
import com.soter.dogp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void setUserLastPoste(Integer newLastPoste, String userEmail) {
        userRepo.alterLastPost(newLastPoste, userEmail);

    }

    public void setImage(Integer user_id, Integer image_id) {
        userRepo.setImageId(user_id, image_id);
    }

    public Integer getOriginPosteByUserId(Integer userid) {
        return userRepo.getHomePostByUserId(userid);
    }
}
