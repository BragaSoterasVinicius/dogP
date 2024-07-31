package com.soter.dogp.objcts;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "posts" )
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "datetime")
    private Date datetime;

    @Column(name = "userid")
    private Integer userId;

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

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getUserid() {
        return userId;
    }

    public String getPost() {
        return post;
    }

    public int getPosteId() {
        return posteId;
    }
}
