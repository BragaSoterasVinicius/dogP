package com.soter.dogp.repo;

import com.soter.dogp.objcts.Posts;
import com.soter.dogp.objcts.User;
import jakarta.transaction.Transactional;
import org.hibernate.type.TrueFalseConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO users(nome, email, senha) VALUES (:nome, :email, :senha)", nativeQuery = true)
    void saveNewUser(String nome, String email, String senha);

    @Query(value = "SELECT senha FROM users WHERE email = :email", nativeQuery = true)
    String searchForUserSenha(String email);


    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    User getUserDataByEmail(String email);

}
