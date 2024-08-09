package com.soter.dogp.repo;

import com.soter.dogp.objcts.Posts;
import com.soter.dogp.objcts.User;
import jakarta.transaction.Transactional;
import org.hibernate.type.TrueFalseConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO users(nome, email, senha, home_post) VALUES (:nome, :email, :senha, :homePoste)", nativeQuery = true)
    void saveNewUser(String nome, String email, String senha, Integer homePoste);

    @Transactional
    @Modifying
    @Query(value = "UPDATE users SET last_post= :posteNum WHERE email= :email", nativeQuery = true)
    void alterLastPost(Integer posteNum, String email);

    @Transactional
    @Modifying
    @Query(value = "UPDATE users SET picture_id= :image_id WHERE user_id= :user_id", nativeQuery = true)
    void setImageId(Integer user_id, Integer image_id);

    @Query(value = "SELECT senha FROM users WHERE email = :email", nativeQuery = true)
    String searchForUserSenha(String email);

    @Query(value = "SELECT * FROM users WHERE user_id = :id", nativeQuery = true)
    User getUserDataById(Integer id);

    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    User getUserDataByEmail(String email);

    @Query(value = "SELECT DISTINCT home_post FROM users", nativeQuery = true)
    List<Integer> getUsedHomePostes();

    @Query(value = "SELECT picture_id FROM users WHERE last_post = :last_post", nativeQuery = true)
    List<String> getPictureIdByLastPost(Integer last_post);

    @Query(value = "SELECT home_post from users WHERE user_id = :id", nativeQuery = true)
    Integer getHomePostByUserId(Integer id);
}
