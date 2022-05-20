package com.example.graphql.service;

import com.example.graphql.model.Actor;
import com.example.graphql.model.Film;
import com.example.graphql.repository.ActorRepository;
import com.example.graphql.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
    @Service
    public class DataLoaderService {

        @Autowired
        private FilmRepository filmRepository;

        @Autowired
        private ActorRepository actorRepository;

        @PostConstruct
        public void loadData() {
            String[] actors = {"Song Kangho", "Lee Jeongjae", "Choi Minsik", "Ha Jeongwoo"};
            Map<String, String> films = new HashMap<String, String>() {
                {
                    put("Song Kangho", "TheHost");
                    put("Lee Jeongjae", "NewWorld");
                    put("Choi Minsik", "OldBoy");
                    put("Ha Jeongwoo", "NamelessGangster");
                }
            };
            List<LocalDate> arrDate = new ArrayList<>();
            arrDate.add(LocalDate.of(2006, 07, 27));
            arrDate.add(LocalDate.of(2013, 02, 21));
            arrDate.add(LocalDate.of(2003, 11, 21));
            arrDate.add(LocalDate.of(2012, 02, 02));

            int i = 0;
            for (String actorName : actors) {
                String[] names = actorName.split(" ");
                Film film = new Film(films.get(actorName), arrDate.get(i));
                filmRepository.save(film);
                Actor actor = new Actor(names[0], names[1], arrDate.get(i), "seoul korea", film.getFilmId());
                actorRepository.save(actor);
                i++;
            }
        }
    }