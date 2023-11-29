package com.tunelink.example.releases.payload;

import lombok.Data;
import org.apache.logging.log4j.util.Strings;

import java.util.List;


@Data
public class ReleaseResponse {
    private List<ReleaseDTO> releases;


    public  ReleaseResponse(List<ReleaseDTO> releases) {
        this.releases = releases;
    }


}

