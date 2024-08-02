package com.soter.dogp.objcts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "cheiro_table")
public class Cheiro {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "datetime")
    private Date datetime;
    @Column(name = "cheirador_id")
    private Integer cheirador_id;
    @Column(name = "cheirado_id")
    private Integer cheirado_id;
    @Column(name = "apelido")
    private String apelido;
    @Column(name = "is_hunted")
    private Boolean is_hunted;

    @Column(name = "poste_id")
    private Integer poste_id;
    public Integer getCheirador_id() {
        return cheirador_id;
    }

    public Integer getCheirado_id() {
        return cheirado_id;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public void setCheirador_id(Integer cheirador_id) {
        this.cheirador_id = cheirador_id;
    }

    public void setCheirado_id(Integer cheirado_id) {
        this.cheirado_id = cheirado_id;
    }

    public Boolean getIs_hunted() {
        return is_hunted;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Integer getPoste_id() {
        return poste_id;
    }

    public void setPoste_id(Integer poste_id) {
        this.poste_id = poste_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIs_hunted(Boolean is_hunted) {
        this.is_hunted = is_hunted;
    }
}
