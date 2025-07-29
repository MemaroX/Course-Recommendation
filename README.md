# Noura: An Advanced Course Recommendation System

"Noura" is an ambitious project aimed at developing a sophisticated and user-centric course recommendation system. Built with a focus on modularity, scalability, and clean architecture, Noura helps Computer Science Engineering (CSE) students navigate their career paths by recommending relevant job tracks and associated learning resources.

## Vision

To create an intelligent recommendation engine that goes beyond simple rule-based suggestions, eventually incorporating advanced algorithms and user profiling to provide highly personalized and adaptive course recommendations.

## Key Features (Current)

- **Modular Design:** Separated concerns for data handling, business logic, and user interaction.
- **Externalized Data:** Job track information is stored in a `job_tracks.json` file, making it easy to update and extend without code changes.
- **Maven Build System:** Standardized project structure and dependency management.
- **Dynamic Recommendation Logic:** Gathers user preferences (e.g., skills, interests) and provides ranked job track recommendations based on a scoring algorithm.
- **Enhanced Console Interface:** Guides users through preference input and presents recommendations clearly.

## Project Structure

```
Noura/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── memarox/
│   │   │           └── noura/
│   │   │               ├── model/             # Data models (e.g., JobTrack.java)
│   │   │               ├── service/           # Business logic and data loading (e.g., JobTrackDataLoader.java, RecommendationService.java)
│   │   │               └── Main.java          # Main application entry point
│   │   └── resources/       # Non-Java resources (e.g., job_tracks.json)
│   │       └── job_tracks.json
├── README.md
└── LICENSE
```

## Technologies Used

- **Java 17+**
- **Maven:** For project build automation and dependency management.
- **Jackson:** For JSON parsing and data binding.

## Getting Started

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/MemaroX/Course-Recommendation.git Noura
    cd Noura
    ```

2.  **Build the project:**
    ```bash
    mvn clean install
    ```

3.  **Run the application:**
    ```bash
    mvn exec:java
    ```
    Follow the prompts to enter your skills and interests, and Noura will provide job track recommendations.

## Future Enhancements (Noura's Roadmap)

- **Advanced Recommendation Algorithms:** Implement collaborative filtering, content-based filtering, or hybrid approaches.
- **User Profiling:** Store and analyze user preferences and historical choices.
- **Web Interface:** Develop a user-friendly web application using frameworks like Spring Boot or Vaadin.
- **Database Integration:** Persist data in a relational database instead of JSON files.
- **Testing:** Comprehensive unit and integration tests.
- **Deployment:** Containerization (Docker) and cloud deployment.
- **Machine Learning Integration:** Utilize libraries like Deeplearning4j or Apache Spark MLlib for more sophisticated recommendations.

## Contributing

We welcome contributions to Noura! Whether it's bug fixes, new features, or architectural improvements, your input is valuable. Please refer to the contribution guidelines (to be added).

## License

This project is licensed under the MIT License - see the `LICENSE` file for details.
