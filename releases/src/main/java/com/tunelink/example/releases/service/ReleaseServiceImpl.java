package com.tunelink.example.releases.service;

import com.tunelink.example.releases.entity.Release;
import com.tunelink.example.releases.entity.ReleaseType;
import com.tunelink.example.releases.exception.ResourceNotFoundException;
import com.tunelink.example.releases.payload.ReleaseDTO;
import com.tunelink.example.releases.payload.ReleaseResponse;
import com.tunelink.example.releases.repository.ReleaseRepository;
import com.tunelink.example.releases.repository.ReleaseTypeRepository;
import org.springframework.stereotype.Service;

// implementation
@Service
public class ReleaseServiceImpl implements  ReleaseService {

    private ReleaseRepository releaseRepository;
    private ReleaseTypeRepository releaseTypeRepository;


    public ReleaseServiceImpl(ReleaseRepository releaseRepository,ReleaseTypeRepository releaseTypeRepository) {
        this.releaseRepository = releaseRepository;
        this.releaseTypeRepository = releaseTypeRepository;
    }



    @Override
    public ReleaseDTO createRelease(ReleaseDTO releaseDto ) {

        // creating a release
        Release release = mapToEntity(releaseDto);

        Release newRelease = releaseRepository.save(release);

        System.out.println();
        return  mapToDTO(newRelease);
    }


    //
    @Override
    public ReleaseDTO updateRelease(ReleaseDTO releaseDTO, long id) {

        Release release = (Release)this.releaseRepository.findById(id).orElseThrow(() -> {
           return  new ResourceNotFoundException("Release", "id", id);
        });



        // update the title, imgUrl, and release date

        System.out.println(releaseDTO.getTitle());
        System.out.println(releaseDTO.getRelease_date());
        System.out.println(releaseDTO.getImgUrl());


        System.out.println("release " + release.getTitle());
        System.out.println("release " + release.getReleaseDate());
        System.out.println("release " + release.getImgUrl());



        if (releaseDTO.getTitle() != null) {
            release.setTitle(releaseDTO.getTitle());
        }

        if (releaseDTO.getRelease_date() != null) {
            release.setReleaseDate(releaseDTO.getRelease_date());
        }

        if (releaseDTO.getImgUrl() != null) {
            release.setImgUrl(releaseDTO.getImgUrl());
        }

        if (releaseDTO.getType() != 0) {
            ReleaseType releaseType = retrieveReleaseType(releaseDTO.getType());

            release.setReleaseType(releaseType);
        }


        Release updatedRelease = (Release)this.releaseRepository.save(release);




        return mapToDTO(updatedRelease);
    }

    // retrieves or throws an error if user cant
    private ReleaseType retrieveReleaseType(long id) {
        return this.releaseTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ReleaseType", "id", id));

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
        releaseDTO.setType(release.getReleaseType().getId());
        return releaseDTO;
    }





}
