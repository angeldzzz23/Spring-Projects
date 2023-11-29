package com.tunelink.example.releases.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


// this is the artist
// Will have more stuff
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "Artists"
)
public class Artist {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String alias;

    @ManyToMany(mappedBy = "artists")
    private Set<Release> releases = new HashSet<>();

}
