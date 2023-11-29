package com.tunelink.example.releases.repository;


import com.tunelink.example.releases.entity.ReleaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReleaseStatusRepository extends JpaRepository<ReleaseStatus, Long> {
}
