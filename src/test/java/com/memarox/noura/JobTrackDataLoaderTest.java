package com.memarox.noura;

import com.memarox.noura.model.JobTrack;
import com.memarox.noura.service.JobTrackDataLoader;
import com.memarox.noura.service.RecommendationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class JobTrackDataLoaderTest {

    private JobTrackDataLoader dataLoader;
    private List<JobTrack> jobTracks;

    @BeforeEach
    void setUp() {
        dataLoader = new JobTrackDataLoader();
        jobTracks = dataLoader.loadJobTracks();
    }

    @Test
    void testLoadJobTracks_notNull() {
        assertNotNull(jobTracks);
    }

    @Test
    void testLoadJobTracks_notEmpty() {
        assertFalse(jobTracks.isEmpty());
    }

    @Test
    void testLoadJobTracks_containsSoftwareEngineer() {
        assertTrue(jobTracks.stream().anyMatch(jt -> jt.getTitle().equals("Software Engineer")));
    }

    @Test
    void testLoadJobTracks_softwareEngineerHasSkills() {
        JobTrack softwareEngineer = jobTracks.stream()
                .filter(jt -> jt.getTitle().equals("Software Engineer"))
                .findFirst()
                .orElse(null);
        assertNotNull(softwareEngineer);
        assertFalse(softwareEngineer.getRequiredSkills().isEmpty());
        assertTrue(softwareEngineer.getRequiredSkills().contains("Problem solving"));
    }
}
