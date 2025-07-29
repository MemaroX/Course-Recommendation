package com.memarox.noura.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.memarox.noura.model.JobTrack;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JobTrackDataLoader {

    public List<JobTrack> loadJobTracks() {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("job_tracks.json")) {
            if (is == null) {
                throw new IOException("job_tracks.json not found in resources.");
            }
            return mapper.readValue(is, new TypeReference<List<JobTrack>>() {});
        } catch (IOException e) {
            System.err.println("Error loading job tracks: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
