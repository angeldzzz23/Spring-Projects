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

    // TODO: releaseType

    // what does cascade mean?
    @OneToOne(mappedBy = "release", cascade = CascadeType.ALL, orphanRemoval = true, optional = true)
    private ReleaseType releaseType;





}


// TODO: Artists

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