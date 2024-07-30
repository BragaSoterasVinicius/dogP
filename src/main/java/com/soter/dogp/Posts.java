package com.soter.dogp;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "posts" )
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "datetime")
    private Date datetime;

    @Column(name = "userid")
    private Integer user_id;

    @Column(name = "post")
    private String post;

    @Column(name = "posteId")
    private Integer posteId;

    public void setId(int id) {
        this.id = id;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setPosteId(int posteId) {
        this.posteId = posteId;
    }

    public int getId() {
        return id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getPost() {
        return post;
    }

    public int getPosteId() {
        return posteId;
    }
}
