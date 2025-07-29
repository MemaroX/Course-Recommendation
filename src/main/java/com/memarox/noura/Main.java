package com.memarox.noura;

import com.memarox.noura.model.JobTrack;
import com.memarox.noura.service.JobTrackDataLoader;
import com.memarox.noura.service.RecommendationService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        JobTrackDataLoader dataLoader = new JobTrackDataLoader();
        List<JobTrack> jobTracks = dataLoader.loadJobTracks();

        if (jobTracks == null || jobTracks.isEmpty()) {
            System.err.println("No job tracks loaded. Exiting.");
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

        // You can add more questions here to gather more preferences
        // e.g., preferred salary range, work environment, interest in specific technologies

        System.out.println("\nAnalyzing your preferences...");
        List<JobTrack> recommendedTracks = recommendationService.getRecommendations(jobTracks, userPreferences);

        System.out.println("\nHere are the job tracks recommended for you:");
        if (recommendedTracks.isEmpty()) {
            System.out.println("No specific recommendations based on your input. Try different keywords!");
        } else {
            for (int i = 0; i < Math.min(5, recommendedTracks.size()); i++) { // Display top 5 recommendations
                JobTrack track = recommendedTracks.get(i);
                System.out.println((i + 1) + ". " + track.getTitle() + " (Score: " + recommendationService.calculateScore(track, userPreferences) + ")");
                System.out.println("   Description: " + track.getDescription());
                System.out.println("   Average Salary: $" + track.getAverageSalary());
                System.out.println("   More Info: " + track.getUrl());
                System.out.println();
            }
        }

        System.out.println("Thank you for using Noura! Best of luck on your career journey.");
        scanner.close();
    }
}