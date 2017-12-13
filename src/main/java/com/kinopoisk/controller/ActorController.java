package com.kinopoisk.controller;

import com.kinopoisk.model.Actor;
import com.kinopoisk.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Maksim Shkurko on 12/7/2017
 *
 * @author m.shkurko
 */

@RestController
@RequestMapping("/api")
public class ActorController {

    @Autowired
    ActorRepository actorRepository;

    @GetMapping("/actors")
    public List<Actor> getAllActors(){return actorRepository.findAll();}

    @GetMapping("/actors/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable(value = "id") Long actorId){
        Actor actor = actorRepository.findOne(actorId);
        if (actor == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(actor);
    }

    @PostMapping("/actors")
    public Actor createActor(@Valid @RequestBody Actor actor){return actorRepository.save(actor);}


    @PutMapping("/actors/{id}")
    public ResponseEntity<Actor> updateActor(@PathVariable(value = "id") Long actorId,
                                             @Valid @RequestBody Actor actorDetails){
        Actor actor = actorRepository.findOne(actorId);
        if (actor == null){
            return ResponseEntity.notFound().build();
        }
        actor.setFullName(actorDetails.getFullName());
        actor.setDateBirth(actorDetails.getDateBirth());
        actor.setPictureUrl(actorDetails.getPictureUrl());
        actor.setBiography(actorDetails.getBiography());

        Actor updateActor = actorRepository.save(actor);
        return ResponseEntity.ok(updateActor);
    }

    @DeleteMapping("/actors/{id}")
    public ResponseEntity<Actor> deleteActor(@PathVariable(value = "id") Long actorId){
        Actor actor = actorRepository.findOne(actorId);
        if (actor == null){
            return ResponseEntity.notFound().build();
        }

        actorRepository.delete(actor);
        return ResponseEntity.ok().build();
    }

   @GetMapping("actors/status")
    public ResponseEntity status(){
       return ResponseEntity.status(200).body("Actor Service is available");
}

}
