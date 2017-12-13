package com.kinopoisk.repository;

import com.kinopoisk.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Maksim Shkurko on 12/7/2017
 *
 * @author m.shkurko
 */
public interface ActorRepository extends JpaRepository<Actor, Long> {
}
