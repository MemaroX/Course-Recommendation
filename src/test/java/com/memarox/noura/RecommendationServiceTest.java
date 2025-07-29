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

public class RecommendationServiceTest {

    private RecommendationService recommendationService;
    private List<JobTrack> allJobTracks;

    @BeforeEach
    void setUp() {
        recommendationService = new RecommendationService();
        JobTrackDataLoader dataLoader = new JobTrackDataLoader();
        allJobTracks = dataLoader.loadJobTracks();
        assertNotNull(allJobTracks, "Job tracks should not be null");
        assertFalse(allJobTracks.isEmpty(), "Job tracks should not be empty");
    }

    @Test
    void testGetRecommendations_softwareDeveloperSkills() {
        Map<String, List<String>> userPreferences = new HashMap<>();
        userPreferences.put("skills", Arrays.asList("Java", "Problem solving", "Data structures and Algorithms"));

        List<JobTrack> recommendations = recommendationService.getRecommendations(allJobTracks, userPreferences);

        assertNotNull(recommendations);
        assertFalse(recommendations.isEmpty());

        // Software Engineer should be highly ranked
        assertEquals("Software Engineer", recommendations.get(0).getTitle());
    }

    @Test
    void testGetRecommendations_dataScientistSkills() {
        Map<String, List<String>> userPreferences = new HashMap<>();
        userPreferences.put("skills", Arrays.asList("Python", "TensorFlow", "Machine Learning"));

        List<JobTrack> recommendations = recommendationService.getRecommendations(allJobTracks, userPreferences);

        assertNotNull(recommendations);
        assertFalse(recommendations.isEmpty());

        // Data Scientist should be highly ranked
        assertEquals("Data Scientist", recommendations.get(0).getTitle());
    }

    @Test
    void testGetRecommendations_noMatchingSkills() {
        Map<String, List<String>> userPreferences = new HashMap<>();
        userPreferences.put("skills", Arrays.asList("NonExistentSkill"));

        List<JobTrack> recommendations = recommendationService.getRecommendations(allJobTracks, userPreferences);

        assertNotNull(recommendations);
        // Should still return all job tracks, but with low scores, so not empty
        assertFalse(recommendations.isEmpty());
        // Check if scores are low or 0 for all
        JobTrack firstTrack = recommendations.get(0);
        assertTrue(recommendationService.calculateScore(firstTrack, userPreferences) <= 10); // Assuming max score for one non-existent skill is low
    }

    @Test
    void testCalculateScore_emptyPreferences() {
        JobTrack softwareEngineer = allJobTracks.stream()
                .filter(jt -> jt.getTitle().equals("Software Engineer"))
                .findFirst()
                .orElse(null);
        assertNotNull(softwareEngineer);

        Map<String, List<String>> userPreferences = new HashMap<>();
        int score = recommendationService.calculateScore(softwareEngineer, userPreferences);
        assertEquals(0, score);
    }

    @Test
    void testCalculateScore_partialMatchSkills() {
        Map<String, List<String>> userPreferences = new HashMap<>();
        userPreferences.put("skills", Arrays.asList("problem")); // Partial match for "Problem solving"

        JobTrack softwareEngineer = allJobTracks.stream()
                .filter(jt -> jt.getTitle().equals("Software Engineer"))
                .findFirst()
                .orElse(null);
        assertNotNull(softwareEngineer);

        int score = recommendationService.calculateScore(softwareEngineer, userPreferences);
        assertTrue(score > 0); // Should get some score for partial match
        // The exact score depends on the weighting, but it should be non-zero
    }
}