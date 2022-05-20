package com.example.graphql.service;

import com.example.graphql.model.Actor;
import com.example.graphql.model.Film;
import com.example.graphql.repository.FilmRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FilmResolver implements GraphQLResolver<Actor> {
    @Autowired
    private FilmRepository filmRepository;

    @Transactional
    public Film getFilm(Actor actor){
        return filmRepository.findById(actor.getFilmId()).get();
    }
}
