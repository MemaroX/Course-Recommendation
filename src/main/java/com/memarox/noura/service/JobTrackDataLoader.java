package com.memarox.noura.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.memarox.noura.model.JobTrack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Service class responsible for loading job track data from a JSON file.
 */
public class JobTrackDataLoader {

    private static final Logger logger = LoggerFactory.getLogger(JobTrackDataLoader.class);

    /**
     * Loads a list of JobTrack objects from the job_tracks.json resource file.
     * @return A list of JobTrack objects, or null if an error occurs during loading.
     */
    public List<JobTrack> loadJobTracks() {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("job_tracks.json")) {
            if (is == null) {
                logger.error("job_tracks.json not found in resources.");
                return null;
            }
            logger.info("Loading job tracks from job_tracks.json...");
            return mapper.readValue(is, new TypeReference<List<JobTrack>>() {});
        } catch (IOException e) {
            logger.error("Error loading job tracks: {}", e.getMessage(), e);
            return null;
        }
    }
}