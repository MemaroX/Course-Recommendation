package com.memarox.noura.service;

import com.memarox.noura.model.JobTrack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service class responsible for generating job track recommendations based on user preferences.
 */
public class RecommendationService {

    private static final Logger logger = LoggerFactory.getLogger(RecommendationService.class);

    /**
     * Generates a ranked list of job track recommendations based on user preferences.
     * The job tracks are scored based on how well they match the provided preferences.
     * @param allJobTracks A list of all available JobTrack objects.
     * @param userPreferences A map of user preferences, where keys are preference categories (e.g., "skills")
     *                        and values are lists of preferred items (e.g., specific skills).
     * @return A sorted list of JobTrack objects, with the most recommended tracks first.
     */
    public List<JobTrack> getRecommendations(List<JobTrack> allJobTracks, Map<String, List<String>> userPreferences) {
        logger.info("Generating recommendations based on user preferences.");
        return allJobTracks.stream()
                .map(jobTrack -> {
                    int score = calculateScore(jobTrack, userPreferences);
                    return new ScoredJobTrack(jobTrack, score);
                })
                .sorted(Comparator.comparingInt(ScoredJobTrack::getScore).reversed())
                .map(ScoredJobTrack::getJobTrack)
                .collect(Collectors.toList());
    }

    /**
     * Calculates a score for a given JobTrack based on how well it matches the user's preferences.
     * The scoring logic can be expanded and refined to include more sophisticated matching criteria.
     * @param jobTrack The JobTrack object to score.
     * @param userPreferences A map of user preferences.
     * @return The calculated score for the job track.
     */
    public int calculateScore(JobTrack jobTrack, Map<String, List<String>> userPreferences) {
        int score = 0;

        List<String> preferredSkills = userPreferences.getOrDefault("skills", List.of());
        for (String skill : preferredSkills) {
            if (jobTrack.getRequiredSkills() != null && jobTrack.getRequiredSkills().contains(skill)) {
                score += 10;
            }
            if (jobTrack.getDevelopmentLanguages() != null && jobTrack.getDevelopmentLanguages().contains(skill)) {
                score += 8;
            }
            if (jobTrack.getDevelopmentFrameworks() != null && jobTrack.getDevelopmentFrameworks().contains(skill)) {
                score += 7;
            }
            if (jobTrack.getMachineLearningAlgorithms() != null && jobTrack.getMachineLearningAlgorithms().contains(skill)) {
                score += 9;
            }
            if (jobTrack.getDataAnalysisTools() != null && jobTrack.getDataAnalysisTools().contains(skill)) {
                score += 7;
            }
            if (jobTrack.getNetworkProtocols() != null && jobTrack.getNetworkProtocols().contains(skill)) {
                score += 6;
            }
            if (jobTrack.getSecurityConfigurationTools() != null && jobTrack.getSecurityConfigurationTools().contains(skill)) {
                score += 6;
            }
            if (jobTrack.getVulnerabilityAssessmentTools() != null && jobTrack.getVulnerabilityAssessmentTools().contains(skill)) {
                score += 8;
            }
            if (jobTrack.getThreatDetectionTechniques() != null && jobTrack.getThreatDetectionTechniques().contains(skill)) {
                score += 8;
            }
            if (jobTrack.getFrontEndTechnologies() != null && jobTrack.getFrontEndTechnologies().contains(skill)) {
                score += 7;
            }
            if (jobTrack.getBackEndTechnologies() != null && jobTrack.getBackEndTechnologies().contains(skill)) {
                score += 7;
            }
            if (jobTrack.getDevelopmentTools() != null && jobTrack.getDevelopmentTools().contains(skill)) {
                score += 6;
            }
            if (jobTrack.getDesignPrinciples() != null && jobTrack.getDesignPrinciples().contains(skill)) {
                score += 5;
            }
            if (jobTrack.getUserResearchMethodologies() != null && jobTrack.getUserResearchMethodologies().contains(skill)) {
                score += 5;
            }
            if (jobTrack.getCommunicationSkills() != null && jobTrack.getCommunicationSkills().contains(skill)) {
                score += 4;
            }
            if (jobTrack.getDocumentationStandards() != null && jobTrack.getDocumentationStandards().contains(skill)) {
                score += 4;
            }
        }

        return score;
    }

    /**
     * Helper class to associate a JobTrack with its calculated score for sorting purposes.
     */
    private static class ScoredJobTrack {
        private final JobTrack jobTrack;
        private final int score;

        /**
         * Constructs a ScoredJobTrack.
         * @param jobTrack The JobTrack object.
         * @param score The calculated score for the job track.
         */
        public ScoredJobTrack(JobTrack jobTrack, int score) {
            this.jobTrack = jobTrack;
            this.score = score;
        }

        /**
         * Returns the JobTrack object.
         * @return The JobTrack.
         */
        public JobTrack getJobTrack() {
            return jobTrack;
        }

        /**
         * Returns the score of the job track.
         * @return The score.
         */
        public int getScore() {
            return score;
        }
    }
}