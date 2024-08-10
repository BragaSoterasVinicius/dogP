package com.soter.dogp.service;

import com.soter.dogp.repo.PostRepo;
import com.soter.dogp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PersonalizeService {
    @Autowired
    PostRepo postRepo;

    public void setupBackground(Integer backgroundId, Integer poste) {
        postRepo.insertBg(poste, backgroundId);
    }

    public String getBackgroundId(Integer poste) {
        Integer bg = postRepo.getBackgroundId(poste);
        if (bg == null) {
            return "0.png";
        }
        return bg.toString()+".png";
    }
}
