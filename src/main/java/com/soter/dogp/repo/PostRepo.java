package com.soter.dogp.repo;

import com.soter.dogp.objcts.Posts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepo extends JpaRepository<Posts, Integer>{
    @Query(value = "SELECT * FROM posts WHERE poste_id = :id", nativeQuery = true)
    List<Posts> findPostsByPosteId(Integer id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO posts(user_id, post, poste_id) VALUES (:user_id, :textcontent, :poste );", nativeQuery = true)
    void createPost(Integer user_id, String textcontent, Integer poste);
    @Query(value = "SELECT * FROM posts WHERE user_id = :user_id", nativeQuery = true)
    List<Posts> getPostsByUserId(Integer user_id);
}
