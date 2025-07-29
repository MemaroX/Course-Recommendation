package com.memarox.noura;

import com.memarox.noura.model.JobTrack;
import com.memarox.noura.service.JobTrackDataLoader;

import java.util.List;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        JobTrackDataLoader dataLoader = new JobTrackDataLoader();
        List<JobTrack> jobTracks = dataLoader.loadJobTracks();

        if (jobTracks == null || jobTracks.isEmpty()) {
            System.err.println("No job tracks loaded. Exiting.");
            return;
        }

        System.out.println();
        System.out.println("Hello, This is a program for those who can't figure out what job track they want from CSE student to another.");
        System.out.println();
        System.out.println("Computer Science has such wonderful fields, everyone has different preferences & We are trying to help.");
        System.out.println();

        System.out.println("Choose what inspires you the most:");
        System.out.println();

        for (int i = 0; i < jobTracks.size(); i++) {
            System.out.println((i + 1) + "- " + jobTracks.get(i).getTitle());
            System.out.println();
        }
        System.out.println((jobTracks.size() + 1) + "- Exit.");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        int userChoice;

        do {
            System.out.print("Enter your choice: ");
            userChoice = scanner.nextInt();

            if (userChoice > 0 && userChoice <= jobTracks.size()) {
                JobTrack selectedTrack = jobTracks.get(userChoice - 1);
                System.out.println("Job Title: " + selectedTrack.getTitle());
                System.out.println("Description: " + selectedTrack.getDescription());
                System.out.println("Required skills: " + selectedTrack.getRequiredSkills());
                System.out.println("Average salary: " + selectedTrack.getAverageSalary());
                System.out.println("More Info: " + selectedTrack.getUrl());
                System.out.println();
            } else if (userChoice == jobTracks.size() + 1) {
                System.out.println("Exit, hope we Helped.");
                System.out.println("Best Luck!");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (userChoice != jobTracks.size() + 1);

        scanner.close();
    }
}
