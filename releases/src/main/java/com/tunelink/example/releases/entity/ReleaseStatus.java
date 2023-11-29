package com.tunelink.example.releases.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//
// draft, submitted, accepted, rejected, delivered
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ReleaseStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
}
