package com.tunelink.example.releases.service;

import com.tunelink.example.releases.entity.Release;
import com.tunelink.example.releases.payload.ReleaseDTO;
import com.tunelink.example.releases.payload.ReleaseResponse;
import com.tunelink.example.releases.repository.ReleaseRepository;
import org.springframework.stereotype.Service;

// implementation
@Service
public class ReleaseServiceImpl implements  ReleaseService {

    private ReleaseRepository releaseRepository;

    public ReleaseServiceImpl(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }


    @Override
    public ReleaseDTO createRelease(ReleaseDTO releaseDto ) {

        // creating a release
        Release release = mapToEntity(releaseDto);

        Release newRelease = releaseRepository.save(release);

        System.out.println();
        return  mapToDTO(newRelease);
    }


    private Release mapToEntity(ReleaseDTO releaseDTO) {
        Release release = new Release();
        release.setImgUrl(releaseDTO.getImgUrl());
        release.setTitle(releaseDTO.getTitle());
        release.setReleaseDate(releaseDTO.getRelease_date());
        releaseDTO.getId();

        return  release;
    }

    private ReleaseDTO mapToDTO(Release release) {
        ReleaseDTO releaseDTO =  new ReleaseDTO();
        releaseDTO.setTitle(release.getTitle());
        releaseDTO.setImgUrl(release.getImgUrl());
        releaseDTO.setRelease_date(release.getReleaseDate());
        releaseDTO.setId(release.getId());

        return releaseDTO;
    }





}
