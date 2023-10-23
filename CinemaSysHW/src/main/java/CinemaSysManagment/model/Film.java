package CinemaSysManagment.model;

import CinemaSysManagment.dao.IFilm;

public class Film implements IFilm {
    private String name;
    private int duration;
    private String genre;
    private String rating;
    private String description;
    private String language;

    public Film(String name, int duration, String genre, String rating, String description, String language) {
        this.name = name;
        this.duration = duration;
        this.genre = genre;
        this.rating = rating;
        this.description = description;
        this.language = language;
    }

    public Film(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public Film(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
