package com.kinopoisk.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Max Shkurko on 17.12.2017.
 */

@Entity
@Table(name = "films_actors")
public class ActorFilms implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "actors_id")
    private long actors_id;

    @Column(name = "films_id")
    private long films_id;

    public long getFilms_id() {
        return films_id;
    }

    public void setFilms_id(long films_id) {
        this.films_id = films_id;
    }

    public long getActors_id() {
        return actors_id;
    }

    public void setActors_id(long actors_id) {
        this.actors_id = actors_id;
    }
}
