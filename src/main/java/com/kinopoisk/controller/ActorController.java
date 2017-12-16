package com.kinopoisk.controller;

import com.kinopoisk.model.Actor;
import com.kinopoisk.model.ActorDto;
import com.kinopoisk.repository.ActorRepository;
import com.kinopoisk.services.ConvertApplication;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maksim Shkurko on 12/7/2017
 *
 * @author m.shkurko
 */

@RestController
@RequestMapping("/api")

@Api(value = "/Actors", description = "Manage actors")
public class ActorController {

    ConvertApplication convertApplication;

    @Autowired
    ActorRepository actorRepository;

    @GetMapping("/actors")
    @ApiOperation(value = "List all Actors")
    public List<ActorDto> getAllActors() {
        convertApplication = new ConvertApplication();
        List<Actor> actorList = actorRepository.findAll();
        List<ActorDto> actorDtoList = new ArrayList<>();
        if (!actorList.isEmpty()){
            for (Actor actor : actorList) {
                actorDtoList.add(convertApplication.parseActorToActorDto(actor));
            }
        }
        return actorDtoList;
    }

    @GetMapping("/actors/{id}")
    @ApiOperation(
            value = "Get Actor by Id"
    )
    public ResponseEntity<ActorDto> getActorById(@PathVariable(value = "id") Long actorId) {
        convertApplication = new ConvertApplication();
        Actor actor = actorRepository.findOne(actorId);
        if (actor == null) {
            return ResponseEntity.notFound().build();
        }
        ActorDto actorDto = convertApplication.parseActorToActorDto(actor);

        return ResponseEntity.ok().body(actorDto);
    }

    @PostMapping("/actors")
    @ApiOperation(
            value = "Create new actor"
    )
    public Actor createActor(@Valid @RequestBody Actor actor) {
        return actorRepository.save(actor);
    }


    @PutMapping("/actors/{id}")
    @ApiOperation(
            value = "Update existing Actor"
    )
    public ResponseEntity<Actor> updateActor(@PathVariable(value = "id") Long actorId,
                                             @Valid @RequestBody Actor actorDetails) {
        Actor actor = actorRepository.findOne(actorId);
        if (actor == null) {
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
    @ApiOperation(value = "Delete existing Actor")
    public ResponseEntity<Actor> deleteActor(@PathVariable(value = "id") Long actorId) {
        Actor actor = actorRepository.findOne(actorId);
        if (actor == null) {
            return ResponseEntity.notFound().build();
        }

        actorRepository.delete(actor);
        return ResponseEntity.ok().build();
    }

    @GetMapping("actors/status")
    @ApiOperation(value = "Check API status")
    public ResponseEntity status() {
        return ResponseEntity.status(200).body("Actor Service is available");
    }

}
