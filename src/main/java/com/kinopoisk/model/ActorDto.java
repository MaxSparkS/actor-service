package com.kinopoisk.model;

import java.util.Date;

/**
 * Created by Max Shkurko on 16.12.2017.
 */
public class ActorDto {

    private long id;

    private String fullName;

    private Date dateBirth;

    private String pictureUrl;

    private String biography;

    public boolean isFavorite;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
