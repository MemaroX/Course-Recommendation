package com.memarox.noura;

import com.memarox.noura.model.JobTrack;
import com.memarox.noura.service.JobTrackDataLoader;
import com.memarox.noura.service.RecommendationService;
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
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Hello, This is Noura, your personal career guide for CSE students.");
        System.out.println();
        System.out.println("Computer Science has such wonderful fields, and we are here to help you find your path.");
        System.out.println();

        // Collect user preferences
        Map<String, List<String>> userPreferences = new HashMap<>();

        System.out.println("To help me recommend the best job track for you, please answer a few questions.");
        System.out.println("Enter skills or interests you have, separated by commas (e.g., Java, Python, AI, Databases):");
        String skillsInput = scanner.nextLine();
        userPreferences.put("skills", Arrays.stream(skillsInput.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList()));

        logger.info("User preferences collected: {}", userPreferences);

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

        scanner.close();
        logger.info("Noura application finished.");
    }
}