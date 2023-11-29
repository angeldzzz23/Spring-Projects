package com.tunelink.example.releases.service;

import com.tunelink.example.releases.entity.Artist;
import com.tunelink.example.releases.entity.Genre;
import com.tunelink.example.releases.entity.Release;
import com.tunelink.example.releases.entity.ReleaseType;
import com.tunelink.example.releases.exception.ResourceNotFoundException;
import com.tunelink.example.releases.payload.ArtistsDTO;
import com.tunelink.example.releases.payload.GenreDTO;
import com.tunelink.example.releases.payload.ReleaseDTO;
import com.tunelink.example.releases.payload.ReleaseResponse;
import com.tunelink.example.releases.repository.ArtistRepository;
import com.tunelink.example.releases.repository.GenreRepository;
import com.tunelink.example.releases.repository.ReleaseRepository;
import com.tunelink.example.releases.repository.ReleaseTypeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

// implementation
@Service
public class ReleaseServiceImpl implements  ReleaseService {

    private ReleaseRepository releaseRepository;
    private ReleaseTypeRepository releaseTypeRepository;
    private ArtistRepository artistRepository;
    private GenreRepository genreRepository;


    public ReleaseServiceImpl(ReleaseRepository releaseRepository,ReleaseTypeRepository releaseTypeRepository,
                              ArtistRepository artistRepository, GenreRepository genreRepository) {
        this.releaseRepository = releaseRepository;
        this.releaseTypeRepository = releaseTypeRepository;
        this.artistRepository = artistRepository;
        this.genreRepository = genreRepository;
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

        if (releaseDTO.getType() != 0) {

             ReleaseType releaseType = retrieveReleaseType(releaseDTO.getType());
            release.setReleaseType(releaseType);
        }

        // saving the artists
        if (releaseDTO.getArtists() != null && !releaseDTO.getArtists().isEmpty()) {
            Set<Artist> artists = new HashSet<>();

            for (ArtistsDTO artist : releaseDTO.getArtists()) {
                Artist carArtist = retrieveArtist(artist.getId()); // Implement this method to retrieve an artist by ID
                artists.add(carArtist);
            }
            release.setArtists(artists);
        }

        // saving the genres
        if (releaseDTO.getGenres() != null && !releaseDTO.getGenres().isEmpty()) {
            Set<Genre> genres = new HashSet<>();

            for (GenreDTO genreDTO : releaseDTO.getGenres()) {
                  Genre genre = retrieveGenres(genreDTO.getId());
                genres.add(genre);
            }
            release.setGenres(genres);
        }

        return  release;
    }

    private Genre retrieveGenres(Long genreId) {
        return this.genreRepository.findById(genreId).orElseThrow(() -> new ResourceNotFoundException("genreId", "id", genreId));
    }

    private Artist retrieveArtist(Long artistId) {
        return this.artistRepository.findById(artistId).orElseThrow(() -> new ResourceNotFoundException("Artist", "id", artistId));
    }

    private ReleaseDTO mapToDTO(Release release) {
        ReleaseDTO releaseDTO =  new ReleaseDTO();
        releaseDTO.setTitle(release.getTitle());
        releaseDTO.setImgUrl(release.getImgUrl());
        releaseDTO.setRelease_date(release.getReleaseDate());
        releaseDTO.setId(release.getId());

        if (release.getReleaseType() != null) {
            releaseDTO.setType(release.getReleaseType().getId());
        }

        // making sure that there are artist an it's not empty
        if (release.getArtists() != null && !release.getArtists().isEmpty()) {

            Set<ArtistsDTO> artists = new HashSet<>();

            for (Artist artist : release.getArtists()) {
                ArtistsDTO artistsDTO =  new ArtistsDTO();
                artistsDTO.setId(artist.getId());

                artists.add(artistsDTO);
            }

            releaseDTO.setArtists((HashSet<ArtistsDTO>) artists);
        }

        // setting the genres
        // can probably set the title here as well
        if (release.getGenres() != null && !release.getGenres().isEmpty()) {

            Set<GenreDTO> genresDTO = new HashSet<>();

            for (Genre genre : release.getGenres()) {
                GenreDTO genreDto =  new GenreDTO();
                genreDto.setId(genre.getId());
                genresDTO.add(genreDto);
            }

            releaseDTO.setGenres((HashSet<GenreDTO>) genresDTO);

        }



        return releaseDTO;
    }





}
