package com.kinopoisk.services;

import com.google.gson.Gson;
import com.kinopoisk.model.Actor;
import com.kinopoisk.model.ActorDto;
import com.kinopoisk.model.FilmDto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

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


    public String readUrl(String urlString){

        String returnString = "";

        try{
            URL url = new URL(urlString);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;
            if(urlConnection instanceof HttpURLConnection)
            {
                connection = (HttpURLConnection) urlConnection;
            }

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String current;
            while((current = in.readLine()) != null)
            {
                returnString += current;
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

        return returnString;
    }


    public FilmDto getFilmDto(long idFilms){

        FilmDto filmDto = new FilmDto();

        String urladdress = "https://gateway-service.herokuapp.com/films/" + idFilms;
        try {
            Gson gSon = new Gson();
            filmDto = gSon.fromJson(readUrl(urladdress), FilmDto.class);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return filmDto;
    }

}
