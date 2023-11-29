package com.tunelink.example.releases.controller;

import com.tunelink.example.releases.entity.Release;
import com.tunelink.example.releases.payload.ReleaseDTO;
import com.tunelink.example.releases.payload.ReleaseResponse;
import com.tunelink.example.releases.service.ReleaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


// ReleaseResponse
@RestController
public class ReleasesController {

    private ReleaseService releaseService;

    public ReleasesController(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }


    // allows the user to enter either body
    // or no body
    @PostMapping("release")
    public ResponseEntity<ReleaseDTO> createRelease(@RequestBody(required = false) ReleaseDTO releaseDto ) {


        ReleaseDTO releaseDTO = releaseService.createRelease(releaseDto);


        return new ResponseEntity<>(releaseDTO, HttpStatus.CREATED);
    }



    @PutMapping("release")
    public ResponseEntity<ReleaseDTO> updateRelease(@RequestBody(required = false) ReleaseDTO releaseDTO) {

        ReleaseDTO re = this.releaseService.updateRelease(releaseDTO, 1);


        return new ResponseEntity<>(re, HttpStatus.OK);
    }


    // this gets the releases

    @GetMapping("releases")
    public ResponseEntity<ReleaseResponse> getAllReleases() {
        ReleaseDTO releaseDTO1 = new ReleaseDTO();
        ReleaseDTO releaseDTO2 = new ReleaseDTO();
        ReleaseDTO releaseDTO3 = new ReleaseDTO();
        ReleaseDTO releaseDTO4 = new ReleaseDTO();

        List<ReleaseDTO> releases = new ArrayList<>();

        releases.add(releaseDTO1);
        releases.add(releaseDTO2);
        releases.add(releaseDTO3);
        releases.add(releaseDTO4);


        ReleaseResponse releaseResponse = new ReleaseResponse(releases);

        return new ResponseEntity<>(releaseResponse, HttpStatus.OK);
    }


}
