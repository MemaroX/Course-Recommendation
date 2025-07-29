package com.memarox.noura;

import com.memarox.noura.entity.User;
import com.memarox.noura.model.JobTrack;
import com.memarox.noura.service.JobTrackDataLoader;
import com.memarox.noura.service.RecommendationService;
import com.memarox.noura.service.UserPreferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Main class for the Noura Course Recommendation System.
 * This class handles user interaction, loads job track data, and provides recommendations.
 */
@SuppressWarnings("ALL")
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Noura application started.");

        JobTrackDataLoader dataLoader = new JobTrackDataLoader();
        List<JobTrack> jobTracks = dataLoader.loadJobTracks();

        if (jobTracks == null || jobTracks.isEmpty()) {
            logger.error("Failed to load job tracks. Application cannot proceed.");
            return;
        }

        RecommendationService recommendationService = new RecommendationService();
        UserPreferenceService userPreferenceService = new UserPreferenceService();
        Scanner scanner = new Scanner(System.in);

        User currentUser = null;
        try {
            System.out.println();
            System.out.println("Hello, This is Noura, your personal career guide for CSE students.");
            System.out.println();
            System.out.print("Please enter your username to load or create your profile: ");
            String username = scanner.nextLine();
            currentUser = userPreferenceService.getOrCreateUser(username);
            logger.info("User logged in: {}", currentUser.getUsername());

            Map<String, List<String>> loadedPreferences = userPreferenceService.loadUserPreferences(currentUser);
            Map<String, List<String>> userPreferences = new HashMap<>(loadedPreferences);

            if (!loadedPreferences.isEmpty()) {
                System.out.println("\nWelcome back, " + currentUser.getUsername() + "! Your saved preferences have been loaded.");
                System.out.println("Current preferences: " + loadedPreferences);
                System.out.println("You can update them now or press Enter to keep them.");
            }

            System.out.println("\nTo help me recommend the best job track for you, please answer a few questions.");

            // Skills Input
            System.out.println("Enter skills or interests you have, separated by commas (e.g., Java, Python, AI, Databases):");
            String skillsInput = scanner.nextLine();
            if (!skillsInput.trim().isEmpty()) {
                userPreferences.put("skills", Arrays.stream(skillsInput.split(","))
                        .map(String::trim)
                        .filter(s -> !s.isEmpty())
                        .collect(Collectors.toList()));
            } else if (!loadedPreferences.containsKey("skills")) {
                userPreferences.put("skills", List.of()); // Ensure key exists even if empty
            }

            // Primary Interest Area Input
            System.out.println("\nWhat is your primary interest area? (e.g., Web Development, Data Science, Cybersecurity, Mobile Development, Game Development, Network Engineering, UX Design, Technical Writing):");
            String interestAreaInput = scanner.nextLine();
            if (!interestAreaInput.trim().isEmpty()) {
                userPreferences.put("primaryInterestArea", List.of(interestAreaInput.trim()));
            } else if (!loadedPreferences.containsKey("primaryInterestArea")) {
                userPreferences.put("primaryInterestArea", List.of());
            }

            // Work Environment Preference Input
            System.out.println("\nDo you prefer working in a startup, large corporation, or research/academic setting? (Type: startup, large corporation, or research/academic):");
            String workEnvironmentInput = scanner.nextLine();
            if (!workEnvironmentInput.trim().isEmpty()) {
                userPreferences.put("workEnvironmentPreference", List.of(workEnvironmentInput.trim()));
            } else if (!loadedPreferences.containsKey("workEnvironmentPreference")) {
                userPreferences.put("workEnvironmentPreference", List.of());
            }

            // Learning Style Preference Input
            System.out.println("\nWhat is your preferred learning style? (e.g., Hands-on Projects, Theoretical Learning, Balanced Approach - separate by commas):");
            String learningStyleInput = scanner.nextLine();
            if (!learningStyleInput.trim().isEmpty()) {
                userPreferences.put("learningStylePreference", Arrays.stream(learningStyleInput.split(","))
                        .map(String::trim)
                        .filter(s -> !s.isEmpty())
                        .collect(Collectors.toList()));
            } else if (!loadedPreferences.containsKey("learningStylePreference")) {
                userPreferences.put("learningStylePreference", List.of());
            }

            logger.info("User preferences collected: {}", userPreferences);

            // Save updated preferences
            userPreferenceService.saveUserPreferences(currentUser, userPreferences);

            System.out.println("\nAnalyzing your preferences...");
            List<JobTrack> recommendedTracks = recommendationService.getRecommendations(jobTracks, userPreferences);

            System.out.println("\nHere are the job tracks recommended for you:");
            if (recommendedTracks.isEmpty()) {
                logger.warn("No specific recommendations found based on user input.");
                System.out.println("No specific recommendations based on your input. Try different keywords!");
            } else {
                for (int i = 0; i < Math.min(5, recommendedTracks.size()); i++) { // Display top 5 recommendations
                    JobTrack track = recommendedTracks.get(i);
                    // Recalculate score for display as the list is sorted by score
                    int scoreForDisplay = recommendationService.calculateScore(track, userPreferences);
                    System.out.println((i + 1) + ". " + track.getTitle() + " (Score: " + scoreForDisplay + ")");
                    System.out.println("   Description: " + track.getDescription());
                    System.out.println("   Average Salary: $" + track.getAverageSalary());
                    System.out.println("   More Info: " + track.getUrl());
                    System.out.println();
                }
                logger.info("Displayed top {} recommendations.", Math.min(5, recommendedTracks.size()));
            }

            // Display menu and handle user choice
            System.out.println("\n--- Job Tracks Menu ---");
            for (int i = 0; i < jobTracks.size(); i++) {
                System.out.println((i + 1) + ". " + jobTracks.get(i).getTitle());
            }
            System.out.println((jobTracks.size() + 1) + ". Exit");

            int userChoice;
            do {
                System.out.print("Enter the number of the job track you want to know more about, or " + (jobTracks.size() + 1) + " to exit: ");
                try {
                    userChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over

                    if (userChoice > 0 && userChoice <= jobTracks.size()) {
                        JobTrack selectedTrack = jobTracks.get(userChoice - 1);
                        System.out.println("\n--- Details for " + selectedTrack.getTitle() + " ---");
                        System.out.println("Description: " + selectedTrack.getDescription());
                        System.out.println("Required skills: " + selectedTrack.getRequiredSkills());
                        System.out.println("Average Salary: $" + selectedTrack.getAverageSalary());
                        System.out.println("More Info: " + selectedTrack.getUrl());
                        System.out.println();
                    } else if (userChoice == jobTracks.size() + 1) {
                        System.out.println("Exiting Noura. Best of luck on your career journey!");
                    } else {
                        System.out.println("Invalid choice. Please enter a number between 1 and " + (jobTracks.size() + 1) + ".");
                    }
                } catch (InputMismatchException e) {
                    logger.warn("Invalid input type: {}", scanner.next()); // Log the invalid input
                    System.out.println("Invalid input. Please enter a number.");
                    userChoice = 0; // Set to 0 to keep loop running
                }
            } while (userChoice != jobTracks.size() + 1);

        } finally {
            scanner.close();
            userPreferenceService.close();
            logger.info("Noura application finished.");
        }
    }
}
