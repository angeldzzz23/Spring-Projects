package com.tunelink.example.releases.service;


import com.tunelink.example.releases.entity.Release;
import com.tunelink.example.releases.payload.ReleaseDTO;
import com.tunelink.example.releases.payload.ReleaseResponse;

public interface ReleaseService {
    ReleaseDTO createRelease(ReleaseDTO releaseDto);
    // update release
    ReleaseDTO updateRelease(ReleaseDTO releaseDTO, long id);



    // delete a releas e


}
