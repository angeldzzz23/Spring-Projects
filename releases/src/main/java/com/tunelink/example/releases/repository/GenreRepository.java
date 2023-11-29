package com.tunelink.example.releases.repository;

import com.tunelink.example.releases.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
