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
            String lowerCaseSkill = skill.toLowerCase();

            // Check required skills
            if (jobTrack.getRequiredSkills() != null) {
                for (String requiredSkill : jobTrack.getRequiredSkills()) {
                    if (requiredSkill.equalsIgnoreCase(skill)) {
                        score += 15; // Exact match, higher score
                    } else if (requiredSkill.toLowerCase().contains(lowerCaseSkill)) {
                        score += 5; // Partial match
                    }
                }
            }

            // Check development languages
            if (jobTrack.getDevelopmentLanguages() != null) {
                for (String lang : jobTrack.getDevelopmentLanguages()) {
                    if (lang.equalsIgnoreCase(skill)) {
                        score += 12;
                    } else if (lang.toLowerCase().contains(lowerCaseSkill)) {
                        score += 4;
                    }
                }
            }

            // Check development frameworks
            if (jobTrack.getDevelopmentFrameworks() != null) {
                for (String framework : jobTrack.getDevelopmentFrameworks()) {
                    if (framework.equalsIgnoreCase(skill)) {
                        score += 10;
                    } else if (framework.toLowerCase().contains(lowerCaseSkill)) {
                        score += 3;
                    }
                }
            }

            // Check ML algorithms
            if (jobTrack.getMachineLearningAlgorithms() != null) {
                for (String algo : jobTrack.getMachineLearningAlgorithms()) {
                    if (algo.equalsIgnoreCase(skill)) {
                        score += 13;
                    } else if (algo.toLowerCase().contains(lowerCaseSkill)) {
                        score += 4;
                    }
                }
            }

            // Check data analysis tools
            if (jobTrack.getDataAnalysisTools() != null) {
                for (String tool : jobTrack.getDataAnalysisTools()) {
                    if (tool.equalsIgnoreCase(skill)) {
                        score += 10;
                    } else if (tool.toLowerCase().contains(lowerCaseSkill)) {
                        score += 3;
                    }
                }
            }

            // Check network protocols
            if (jobTrack.getNetworkProtocols() != null) {
                for (String protocol : jobTrack.getNetworkProtocols()) {
                    if (protocol.equalsIgnoreCase(skill)) {
                        score += 9;
                    } else if (protocol.toLowerCase().contains(lowerCaseSkill)) {
                        score += 3;
                    }
                }
            }

            // Check security configuration tools
            if (jobTrack.getSecurityConfigurationTools() != null) {
                for (String tool : jobTrack.getSecurityConfigurationTools()) {
                    if (tool.equalsIgnoreCase(skill)) {
                        score += 9;
                    } else if (tool.toLowerCase().contains(lowerCaseSkill)) {
                        score += 3;
                    }
                }
            }

            // Check vulnerability assessment tools
            if (jobTrack.getVulnerabilityAssessmentTools() != null) {
                for (String tool : jobTrack.getVulnerabilityAssessmentTools()) {
                    if (tool.equalsIgnoreCase(skill)) {
                        score += 11;
                    } else if (tool.toLowerCase().contains(lowerCaseSkill)) {
                        score += 4;
                    }
                }
            }

            // Check threat detection techniques
            if (jobTrack.getThreatDetectionTechniques() != null) {
                for (String technique : jobTrack.getThreatDetectionTechniques()) {
                    if (technique.equalsIgnoreCase(skill)) {
                        score += 11;
                    } else if (technique.toLowerCase().contains(lowerCaseSkill)) {
                        score += 4;
                    }
                }
            }

            // Check front-end technologies
            if (jobTrack.getFrontEndTechnologies() != null) {
                for (String tech : jobTrack.getFrontEndTechnologies()) {
                    if (tech.equalsIgnoreCase(skill)) {
                        score += 10;
                    } else if (tech.toLowerCase().contains(lowerCaseSkill)) {
                        score += 3;
                    }
                }
            }

            // Check back-end technologies
            if (jobTrack.getBackEndTechnologies() != null) {
                for (String tech : jobTrack.getBackEndTechnologies()) {
                    if (tech.equalsIgnoreCase(skill)) {
                        score += 10;
                    } else if (tech.toLowerCase().contains(lowerCaseSkill)) {
                        score += 3;
                    }
                }
            }

            // Check development tools (Game Dev)
            if (jobTrack.getDevelopmentTools() != null) {
                for (String tool : jobTrack.getDevelopmentTools()) {
                    if (tool.equalsIgnoreCase(skill)) {
                        score += 9;
                    } else if (tool.toLowerCase().contains(lowerCaseSkill)) {
                        score += 3;
                    }
                }
            }

            // Check design principles (UX)
            if (jobTrack.getDesignPrinciples() != null) {
                for (String principle : jobTrack.getDesignPrinciples()) {
                    if (principle.equalsIgnoreCase(skill)) {
                        score += 8;
                    } else if (principle.toLowerCase().contains(lowerCaseSkill)) {
                        score += 2;
                    }
                }
            }

            // Check user research methodologies (UX)
            if (jobTrack.getUserResearchMethodologies() != null) {
                for (String method : jobTrack.getUserResearchMethodologies()) {
                    if (method.equalsIgnoreCase(skill)) {
                        score += 8;
                    } else if (method.toLowerCase().contains(lowerCaseSkill)) {
                        score += 2;
                    }
                }
            }

            // Check communication skills (Tech Writer)
            if (jobTrack.getCommunicationSkills() != null) {
                for (String commSkill : jobTrack.getCommunicationSkills()) {
                    if (commSkill.equalsIgnoreCase(skill)) {
                        score += 7;
                    } else if (commSkill.toLowerCase().contains(lowerCaseSkill)) {
                        score += 2;
                    }
                }
            }

            // Check documentation standards (Tech Writer)
            if (jobTrack.getDocumentationStandards() != null) {
                for (String standard : jobTrack.getDocumentationStandards()) {
                    if (standard.equalsIgnoreCase(skill)) {
                        score += 7;
                    } else if (standard.toLowerCase().contains(lowerCaseSkill)) {
                        score += 2;
                    }
                }
            }
        }

        // Score based on primary interest area
        String preferredInterestArea = userPreferences.getOrDefault("primaryInterestArea", List.of("")).get(0);
        if (!preferredInterestArea.isEmpty() && jobTrack.getPrimaryInterestArea() != null &&
            jobTrack.getPrimaryInterestArea().equalsIgnoreCase(preferredInterestArea)) {
            score += 20; // High score for matching primary interest
        }

        // Score based on work environment preference
        String preferredWorkEnvironment = userPreferences.getOrDefault("workEnvironmentPreference", List.of("")).get(0);
        if (!preferredWorkEnvironment.isEmpty() && jobTrack.getWorkEnvironmentPreference() != null &&
            jobTrack.getWorkEnvironmentPreference().equalsIgnoreCase(preferredWorkEnvironment)) {
            score += 15; // Good score for matching work environment
        }

        // Score based on learning style preference
        List<String> preferredLearningStyles = userPreferences.getOrDefault("learningStylePreference", List.of());
        if (jobTrack.getLearningStylePreference() != null) {
            for (String style : preferredLearningStyles) {
                if (jobTrack.getLearningStylePreference().contains(style)) {
                    score += 10; // Score for matching learning style
                }
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