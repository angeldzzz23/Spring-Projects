package com.tunelink.example.releases.payload;

import java.util.List;

public class ReleaseDTO2 {
    private long id;
    private String title; // title of the release
    private String release_date; //
    private String imgUrl;
    private String releaseType; //
    private List<String> artists; // a  release can have more than one artist
    private String status;
}
