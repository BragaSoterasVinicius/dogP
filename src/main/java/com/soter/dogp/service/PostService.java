package com.soter.dogp.service;

import com.soter.dogp.objcts.Posts;
import com.soter.dogp.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    public List<Posts> getPostsByPoste(Integer posteNumber){
        List<Posts> postePosts = postRepo.findPostsByPosteId(posteNumber);
        return postePosts;
    }
    public void makePost(Integer userId, String text, Integer poste){
        postRepo.createPost(userId, text, poste);
    }
}
