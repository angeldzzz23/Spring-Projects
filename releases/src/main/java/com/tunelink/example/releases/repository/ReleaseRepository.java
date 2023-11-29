package com.tunelink.example.releases.repository;

import com.tunelink.example.releases.entity.Release;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReleaseRepository extends JpaRepository<Release, Long> {

}
