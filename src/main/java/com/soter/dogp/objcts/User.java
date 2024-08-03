package com.soter.dogp.objcts;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.Query;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer user_id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;
    @Column(name = "last_post")
    private Integer last_post;

    @Column(name = "picture_id")
    private Integer picture_id;
    public Integer getUser_id() {
        return user_id;
    }
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getLast_post() {
        return last_post;
    }

    public void setLast_post(Integer last_post) {
        this.last_post = last_post;
    }

    public Integer getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(Integer picture_id) {
        this.picture_id = picture_id;
    }
}
