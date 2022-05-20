package com.example.graphql.service;
import com.example.graphql.model.Actor;
import com.example.graphql.model.AddressInput;
import com.example.graphql.repository.ActorRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class ActorService implements GraphQLQueryResolver, GraphQLMutationResolver{
    private ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    // query
    public List<Actor> getAllActors(){
        return actorRepository.findAll();
    }
    public Actor getActorById(Integer id){
        return actorRepository.findById(id).get();
    }

    // mutation
    @Transactional
    public Actor updateAddress(Integer id, String address){
        Actor actor =  actorRepository.findById(id).get();
        actor.setAddress(address);
        actorRepository.save(actor);
        return actor;
    }
    // 입력 개체를 얻을 수 있음
    @Transactional
    public Actor updateAddressByInputObject(AddressInput input){
        Actor actor =  actorRepository.findById(input.getActorId()).get();
        actor.setAddress(input.getAddress());
        actorRepository.save(actor);
        return actor;
    }
}
