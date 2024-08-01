package com.soter.dogp.objcts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cheiro_table")
public class Cheiro {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "cheirador_id")
    private Integer cheirador_id;
    @Column(name = "cheirado_id")
    private Integer cheirado_id;
    @Column(name = "apelido")
    private Integer apelido;
    @Column(name = "is_hunted")
    private Boolean is_hunted;
    public Integer getCheirador_id() {
        return cheirador_id;
    }

    public Integer getCheirado_id() {
        return cheirado_id;
    }

    public Integer getApelido() {
        return apelido;
    }

    public void setApelido(Integer apelido) {
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

    public void setIs_hunted(Boolean is_hunted) {
        this.is_hunted = is_hunted;
    }
}
