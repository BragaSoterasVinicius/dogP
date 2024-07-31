package com.soter.dogp.repo;

import com.soter.dogp.objcts.Posts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepo extends JpaRepository<Posts, Integer>{
    @Query(value = "SELECT * FROM posts WHERE posteId = :id", nativeQuery = true)
    List<Posts> findPostsByPosteId(Integer id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO posts(userId, post, posteId) VALUES (:userId, :textcontent, :poste );", nativeQuery = true)
    void createPost(int userId, String textcontent, int poste);

}
