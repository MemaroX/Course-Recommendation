# Noura: An Advanced Course Recommendation System

"Noura" is an ambitious project aimed at developing a sophisticated and user-centric course recommendation system. Built with a focus on modularity, scalability, and clean architecture, Noura helps Computer Science Engineering (CSE) students navigate their career paths by recommending relevant job tracks and associated learning resources.

## Vision

To create an intelligent recommendation engine that goes beyond simple rule-based suggestions, eventually incorporating advanced algorithms and user profiling to provide highly personalized and adaptive course recommendations.

## Key Features (Current)

- **Modular Design:** Separated concerns for data handling, business logic, and user interaction.
- **Externalized Data:** Job track information is stored in a `job_tracks.json` file, making it easy to update and extend without code changes.
- **Maven Build System:** Standardized project structure and dependency management.
- **Dynamic Recommendation Logic:** Gathers detailed user preferences (e.g., skills, primary interest area, work environment, learning style) and provides highly personalized, ranked job track recommendations based on a nuanced scoring algorithm that considers exact and partial matches.
- **Robust Error Handling:** Improved input validation and graceful handling of potential issues during data loading and user interaction.

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
- **JUnit 5:** For unit testing.
- **SLF4J & Logback:** For robust logging.

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

## Running Tests

To run the unit tests and ensure the core logic is functioning correctly:

```bash
mvn test
```

## Logging

Noura uses SLF4J with Logback for logging. The `logback.xml` configuration file in `src/main/resources` controls the logging behavior. By default, logs are printed to the console. You can adjust the logging level (e.g., `info`, `debug`, `error`) and appenders as needed.

## Documentation (Javadoc)

Comprehensive Javadoc comments have been added throughout the codebase to explain classes, methods, and important fields. To generate the Javadoc documentation:

```bash
mvn javadoc:javadoc
```

This will generate HTML documentation in the `target/site/apidocs` directory.


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
