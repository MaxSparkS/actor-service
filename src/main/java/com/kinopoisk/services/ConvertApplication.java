package com.kinopoisk.services;

import com.kinopoisk.model.Actor;
import com.kinopoisk.model.ActorDto;

/**
 * Created by Max Shkurko on 16.12.2017.
 */
public class ConvertApplication {

    public ActorDto parseActorToActorDto(Actor actor){
        ActorDto actorDto = new ActorDto();

        actorDto.setId(actor.getId());
        actorDto.setFullName(actor.getFullName());
        actorDto.setDateBirth(actor.getDateBirth());
        actorDto.setPictureUrl(actor.getPictureUrl());
        actorDto.setBiography(actor.getBiography());

        return actorDto;

    }

}
