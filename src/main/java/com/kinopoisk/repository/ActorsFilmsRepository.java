package com.kinopoisk.repository;

import com.kinopoisk.model.ActorFilms;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Max Shkurko on 17.12.2017.
 */
public interface ActorsFilmsRepository extends JpaRepository<ActorFilms, Long>{
}
