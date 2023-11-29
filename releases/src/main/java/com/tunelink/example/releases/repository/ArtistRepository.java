package com.tunelink.example.releases.repository;

import com.tunelink.example.releases.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

}
