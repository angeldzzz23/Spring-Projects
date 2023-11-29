package com.tunelink.example.releases.payload;

import com.tunelink.example.releases.entity.Genre;
import lombok.Data;

import java.util.HashSet;
import java.util.List;


@Data
public class ReleaseDTO {
    private long id;
    private String title; // title of the release
    private String release_date; //
    private String imgUrl;
    private long type;
    private HashSet<ArtistsDTO> artists;
    private HashSet<GenreDTO> genres;


    public ReleaseDTO(long id, String title, String date) {
        this.id = id;
        this.title = title;
        this.release_date = date;
    }

    public ReleaseDTO() {

    }
    // getters
    public long getId() {
        return id;
    }

    public long getType() {
        return this.type;
    }

    public void setType(long id) {
        this.type = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return release_date;
    }

    // setters
    public void setId(long id) {
        this.id = id;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.release_date = date;
    }


}
