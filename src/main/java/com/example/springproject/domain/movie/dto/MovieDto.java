package com.example.springproject.domain.movie.dto;


public class MovieDto {
    private Long id;
    private String title;
    private String original_title;
    private Integer release_year;
    private String genre;
    private boolean promoted;

    public MovieDto(Long id, String title, String original_title, Integer release_year, String genre, boolean promoted) {
        this.id = id;
        this.title = title;
        this.original_title = original_title;
        this.release_year = release_year;
        this.genre = genre;
        this.promoted = promoted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public Integer getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Integer release_year) {
        this.release_year = release_year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }
}
