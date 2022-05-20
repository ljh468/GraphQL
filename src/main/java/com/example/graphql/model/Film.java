package com.example.graphql.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "FILM")
@Getter
@Setter
public class Film {

    @Id
    @Column(name = "FILM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer filmId;

    @Column(name = "NAME")
    private String name;
    @Column(name = "regDt")
    private LocalDate regDt;

    public Film(){}
    public Film(String name, LocalDate regDt) {
        this.name = name;
        this.regDt = regDt;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getRegDt() {
        return regDt;
    }

    public void setRegDt(LocalDate regDt) {
        this.regDt = regDt;
    }
}
