package com.tunelink.example.releases.repository;

import com.tunelink.example.releases.entity.ReleaseType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReleaseTypeRepository extends JpaRepository<ReleaseType, Long> {

}
