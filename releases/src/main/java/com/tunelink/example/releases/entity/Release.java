package com.tunelink.example.releases.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "releases"
)

public class Release {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "title", nullable = true)
    private String title;

    @Column(name = "releaseDate", nullable = true)
    private String releaseDate;

    @Column(name = "imgUrl", nullable = true)
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "release_type_id", nullable = true)
    private ReleaseType releaseType;

    @ManyToMany
    @JoinTable(
            name = "release_artists",
            joinColumns = @JoinColumn(name = "release_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private Set<Artist> artists = new HashSet<>();


    @ManyToMany
    @JoinTable(
            name = "release_genres",
            joinColumns = @JoinColumn(name = "release_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();



}



// TODO: Status

// TODO: tracks

// TODO: Genres

/*

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(
        name = "post", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
)
public class Post {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "content", nullable = false)
    private String content;

    // what does cascade mean?
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();







}


 */