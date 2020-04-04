package com.example.movieapp.model;

public class Movies {

    private String Title;
    private String Year;
    private String rated;
    private String Released_Date;
    private String Genre;
    private String Director;
    private String Writer;
    private String Actors;
    private String plot;
    private String Language;
    private String Country;
    private String poster_url;
    private String meta_score;
    private String imdb_rating;
    private String Runtime;


    public Movies() {

    }

    public Movies(String title, String year, String rated, String released_Date, String genre, String director, String writer, String actors, String plot, String language, String country, String poster_url, String meta_score, String imdb_rating , String Runtime) {
        Title = title;
        Year = year;
        this.rated = rated;
        Released_Date = released_Date;
        Genre = genre;
        Director = director;
        Writer = writer;
        Actors = actors;
        this.plot = plot;
        Language = language;
        Country = country;
        this.poster_url = poster_url;
        this.meta_score = meta_score;
        this.imdb_rating = imdb_rating;
        this.Runtime = Runtime;
    }

    public String getTitle() {
        return Title;
    }

    public String getYear() {
        return Year;
    }

    public String getRated() {
        return rated;
    }

    public String getReleased_Date() {
        return Released_Date;
    }

    public String getGenre() {
        return Genre;
    }

    public String getDirector() {
        return Director;
    }

    public String getWriter() {
        return Writer;
    }

    public String getActors() {
        return Actors;
    }

    public String getPlot() {
        return plot;
    }

    public String getLanguage() {
        return Language;
    }

    public String getCountry() {
        return Country;
    }

    public String getPoster_url() {
        return poster_url;
    }

    public String getMeta_score() {
        return meta_score;
    }

    public String getImdb_rating() {
        return imdb_rating;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setYear(String year) {
        Year = year;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public void setReleased_Date(String released_Date) {
        Released_Date = released_Date;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setPoster_url(String poster_url) {
        this.poster_url = poster_url;
    }

    public void setMeta_score(String meta_score) {
        this.meta_score = meta_score;
    }

    public void setImdb_rating(String imdb_rating) {
        this.imdb_rating = imdb_rating;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }
}
