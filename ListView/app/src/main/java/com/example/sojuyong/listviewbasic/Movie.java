package com.example.sojuyong.listviewbasic;

import java.util.Objects;

public class Movie {

    //  Field
    private int poster;
    private String name;
    private String genre;
    private String actors;
    private String releaseDate;

    //  Constructor
    public Movie(int poster, String name, String genre, String actors, String releaseDate) {
        this.poster = poster;
        this.name = name;
        this.genre = genre;
        this.actors = actors;
        this.releaseDate = releaseDate;
    }

    private Movie() {

    }

    //  Getter & Setter
    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name) &&
                Objects.equals(genre, movie.genre) &&
                Objects.equals(actors, movie.actors) &&
                Objects.equals(releaseDate, movie.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, genre, actors, releaseDate);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", actors='" + actors + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
