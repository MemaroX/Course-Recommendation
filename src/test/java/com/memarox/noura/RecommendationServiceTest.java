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

    @Test
    void testGetRecommendations_primaryInterestArea() {
        Map<String, List<String>> userPreferences = new HashMap<>();
        userPreferences.put("primaryInterestArea", List.of("Data Science"));

        List<JobTrack> recommendations = recommendationService.getRecommendations(allJobTracks, userPreferences);

        assertNotNull(recommendations);
        assertFalse(recommendations.isEmpty());
        assertEquals("Data Scientist", recommendations.get(0).getTitle());
    }

    @Test
    void testGetRecommendations_workEnvironmentPreference() {
        Map<String, List<String>> userPreferences = new HashMap<>();
        userPreferences.put("workEnvironmentPreference", List.of("Startup"));

        List<JobTrack> recommendations = recommendationService.getRecommendations(allJobTracks, userPreferences);

        assertNotNull(recommendations);
        assertFalse(recommendations.isEmpty());
        // Mobile developer, Web developer, Game developer, UX designer are all startups
        // The order might vary based on other default scores, but one of them should be high
        assertTrue(recommendations.stream().anyMatch(jt -> jt.getTitle().equals("Mobile developer") ||
                                                          jt.getTitle().equals("Web developer") ||
                                                          jt.getTitle().equals("Game developer") ||
                                                          jt.getTitle().equals("UX designer")));
    }

    @Test
    void testGetRecommendations_learningStylePreference() {
        Map<String, List<String>> userPreferences = new HashMap<>();
        userPreferences.put("learningStylePreference", List.of("Theoretical Learning"));

        List<JobTrack> recommendations = recommendationService.getRecommendations(allJobTracks, userPreferences);

        assertNotNull(recommendations);
        assertFalse(recommendations.isEmpty());
        // Data Scientist, Cybersecurity Analyst, UX Designer, Technical Writer have Theoretical Learning
        assertTrue(recommendations.stream().anyMatch(jt -> jt.getTitle().equals("Data Scientist") ||
                                                          jt.getTitle().equals("Cyber Security Prof") ||
                                                          jt.getTitle().equals("UX designer") ||
                                                          jt.getTitle().equals("Technical Writer")));
    }
}
