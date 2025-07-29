package com.memarox.noura.service;

import com.memarox.noura.model.JobTrack;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RecommendationService {

    public List<JobTrack> getRecommendations(List<JobTrack> allJobTracks, Map<String, List<String>> userPreferences) {
        return allJobTracks.stream()
                .map(jobTrack -> {
                    int score = calculateScore(jobTrack, userPreferences);
                    return new ScoredJobTrack(jobTrack, score);
                })
                .sorted(Comparator.comparingInt(ScoredJobTrack::getScore).reversed())
                .map(ScoredJobTrack::getJobTrack)
                .collect(Collectors.toList());
    }

    private int calculateScore(JobTrack jobTrack, Map<String, List<String>> userPreferences) {
        int score = 0;

        // Example scoring logic: match skills, languages, tools, etc.
        // This can be expanded and refined significantly

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

        // Add more scoring criteria based on other preferences if needed

        return score;
    }

    private static class ScoredJobTrack {
        private final JobTrack jobTrack;
        private final int score;

        public ScoredJobTrack(JobTrack jobTrack, int score) {
            this.jobTrack = jobTrack;
            this.score = score;
        }

        public JobTrack getJobTrack() {
            return jobTrack;
        }

        public int getScore() {
            return score;
        }
    }
}
