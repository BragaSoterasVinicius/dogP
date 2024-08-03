package com.soter.dogp.service;

import com.soter.dogp.controller.ImageController;
import com.soter.dogp.objcts.Posts;
import com.soter.dogp.objcts.User;
import com.soter.dogp.repo.PostRepo;
import com.soter.dogp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DogService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ImageController imageController;

    public List<String> getImagesByPosteId(Integer posteId){
        List<String> imgsIds = getAllUsersDogs(posteId);
        return imgsIds;
    }
    public List<String> getAllUsersDogs(Integer posteId){
        List<String> imagesIdOnBoard = userRepo.getPictureIdByLastPost(posteId);
        for(int n = 0; n < imagesIdOnBoard.size(); n++){
            imagesIdOnBoard.set(n,imagesIdOnBoard.get(n)+".png" );
        }
        return imagesIdOnBoard;
    }

}