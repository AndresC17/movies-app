package models;

import com.fasterxml.jackson.annotation.*;

public final class Movie {
    
    public final boolean adult;
    public final String backdrop_path;
    public final int[] genre_ids;
    public final long id;
    public final String original_language;
    public final String original_title;
    public final String overview;
    public final double popularity;
    public final String poster_path;
    public final String release_date;
    public final String title;
    public final boolean video;
    public final double vote_average;
    public final long vote_count;

    public final String url;
    public final boolean has_subtitles;
    public final String origin_country;
    public final String duration;
    public final String production_date;
    public final String classification;

    @JsonCreator
    public Movie(
        @JsonProperty("adult") boolean adult,
        @JsonProperty("backdrop_path") String backdrop_path,
        @JsonProperty("genre_ids") int[] genre_ids,
        @JsonProperty("id") long id,
        @JsonProperty("original_language") String original_language,
        @JsonProperty("original_title") String original_title,
        @JsonProperty("overview") String overview,
        @JsonProperty("popularity") double popularity,
        @JsonProperty("poster_path") String poster_path,
        @JsonProperty("release_date") String release_date,
        @JsonProperty("title") String title,
        @JsonProperty("video") boolean video,
        @JsonProperty("vote_average") double vote_average,
        @JsonProperty("vote_count") long vote_count,
        
        @JsonProperty("url") String url,
        @JsonProperty("has_subtitles") boolean has_subtitles,
        @JsonProperty("origin_country") String origin_country,
        @JsonProperty("duration") String duration,
        @JsonProperty("production_date") String production_date,
        @JsonProperty("classification") String classification
    ){
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.genre_ids = genre_ids;
        this.id = id;
        this.original_language = original_language;
        this.original_title = original_title;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.title = title;
        this.video = video;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
        
        this.url = url;
        this.has_subtitles = has_subtitles;
        this.origin_country = origin_country;
        this.duration = duration;
        this.production_date = production_date;
        this.classification = classification;
    }
}
