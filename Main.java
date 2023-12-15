import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {

//      Objects properties

        // SoftWare
        SoftwareDeveloper softwaredeveloper = new SoftwareDeveloper();

        softwaredeveloper.setTitle("Software Engineer");
        softwaredeveloper.setDescription("Create new software and improve existing software applications,they design and write code used to build everything from OS to mobile apps ");
        softwaredeveloper.setRequiredSkills(List.of("Data structures and Algorithms", "Database", "Problem solving", "Programming languages"));
        softwaredeveloper.setAverageSalary(120000);
        softwaredeveloper.setDevelopmentLanguages(List.of("Python", "Ruby", "Java", "PHP", "JS", "C++"));
        softwaredeveloper.setDevelopmentFrameworks(List.of("PyTorch", "Garden", "Spring", "Play", "Spark", "CakePHP", "ReactJS", "TensorFlow"));


        // Data science
        DataScientist dataScientist = new DataScientist();

        dataScientist.setTitle("Data Scientist");
        dataScientist.setDescription("Extract and analyze data to make informed decisions using a series of algorithms and tools to extract insights from structured and unstructured data");
        dataScientist.setRequiredSkills(List.of("Matplotlib", "Scikit-learn", "Jupyter", "TensorFlow", "Excel", "Python", "Tableau"));
        dataScientist.setAverageSalary(138000);
        dataScientist.setMachineLearningAlgorithms(List.of("Logistic Regression", "Linear Regression", "Naive Bayes", "SVM", "Decision Tree", "KNN", "Random Forest", "Clustering", "Neural Network"));
        dataScientist.setDataAnalysisTools(List.of("Matplotlib", "Scikit-learn", "PyTorch", "Trifacta", "Excel", "BigML", "R"));


        // Network
        NetworkEngineer networkEngineer = new NetworkEngineer();

        networkEngineer.setTitle("Network Engineer");
        networkEngineer.setDescription("Monitor,troubleshoot and maintain networks in a 24/7 environment to ensure stability and security");
        networkEngineer.setRequiredSkills(List.of("CCNA", "Network Security", "Network Fundamentals"));
        networkEngineer.setAverageSalary(80300);
        networkEngineer.setNetworkProtocols(List.of("HTTP", "FTP", "TCP", "POP3", "DNS", "SSH", "Telnet", "SMTP", "Border Gateway Protocol", "DHCP", "UDP", "Simple Network Management Protocol"));
        networkEngineer.setSecurityConfigurationTools(List.of("Net LineDancer", "rConfig", "Kiwi CatTools", "SolarWinds Network Configuration Management", "Bladelogic network automation"));


        // Cyber Security
        CybersecurityAnalyst cybersecurityAnalyst = new CybersecurityAnalyst();

        cybersecurityAnalyst.setTitle("Cyber Security Prof");
        cybersecurityAnalyst.setDescription("Develop strategies to protect organizations from cyber-attacks and disruptions");
        cybersecurityAnalyst.setRequiredSkills(List.of("OS", "C Programming", "Network Fundamentals"));
        cybersecurityAnalyst.setAverageSalary(119700);
        cybersecurityAnalyst.setVulnerabilityAssessmentTools(List.of("Nessus", "OpenSCAP", "OpenVAS", "Nmap", "Vulnerability Scanner", "Wireshark", "App scanner", "W3af"));
        cybersecurityAnalyst.setThreatDetectionTechniques(List.of("PoSATM", "Anomaly Detection", "Signature-based Detection", "Heuristic Analysis", "Sandboxing", "Honey Pots and Honey Nets", "EDR", "AI & ML"));




        // Web
        WebDeveloper webDeveloper = new WebDeveloper();

        webDeveloper.setTitle("Web developer");
        webDeveloper.setDescription("Creating, building, and maintaining of websites");
        webDeveloper.setRequiredSkills(List.of("Front-Eng technologies", "Back-End technologies"));
        webDeveloper.setAverageSalary(81700);
        webDeveloper.setFrontEndTechnologies(List.of("HTML", "CSS", "JavaScript", "Bootstrap"));
        webDeveloper.setBackEndTechnologies(List.of("PHP", "Java", "Python", "Node.JS"));



        // Mobile
        MobileDeveloper mobileDeveloper = new MobileDeveloper();

        mobileDeveloper.setTitle("Mobile developer");
        mobileDeveloper.setDescription(" Mobile apps are often written specifically to take advantage of the unique features of a particular mobile device");
        mobileDeveloper.setRequiredSkills(List.of("Programming languages", "Logical thinking", "Design knowledge"));
        mobileDeveloper.setAverageSalary(12700);



        // Games
        GameDeveloper gameDeveloper = new GameDeveloper();

        gameDeveloper.setTitle("Game developer");
        gameDeveloper.setDescription("They are responsible for bringing a video game from concept to reality. To do this, video game developers must code and program visual elements and other features. They also run tests to make sure the game performs well.");
        gameDeveloper.setRequiredSkills(List.of("Coding", "Design", "monitoring"));
        gameDeveloper.setAverageSalary(87000);
        gameDeveloper.setDevelopmentTools(List.of(""));
        gameDeveloper.setDevelopmentTools(List.of(" Character Creator Pipeline", "Mixamo", "CeltX", "Blender", "Incredibuild", "GameBench"));
        gameDeveloper.setGameEngine("Amazon Lumberyard");


        // UX
        UserExperienceDesigner userExperienceDesigner = new UserExperienceDesigner();

        userExperienceDesigner.setTitle("UX designer");
        userExperienceDesigner.setDescription("Create products that provide meaningful and relevant experiences to users.");
        userExperienceDesigner.setRequiredSkills(List.of("Network", "Design", "portfolio", "UX course"));
        userExperienceDesigner.setAverageSalary(94500);
        userExperienceDesigner.setDesignPrinciples(List.of("User-centricity", "Consistency", "Hierarchy", "Context", "User control", "Accessibility", "Usability"));
        userExperienceDesigner.setUserResearchMethodologies(List.of("User interview", "Survey", "Focus Group Discussion", "Card Sorting", "Sales Analytics", "Competitor Analysis"));



        // Tech Writing
        TechnicalWriter technicalWriter = new TechnicalWriter();

        technicalWriter.setTitle("Technical Writer");
        technicalWriter.setDescription("Create content to provide instructions or explain technical concepts regarding environmental regulations, computer applications or medical procedures.");
        technicalWriter.setRequiredSkills(List.of("Computer skill", "Learn style guides", "Develop a portfolio"));
        technicalWriter.setAverageSalary(81800);
        technicalWriter.setCommunicationSkills(List.of("Information design", "Technical writing", "Technical editing", "Marketing"));
        technicalWriter.setDocumentationStandards(List.of("Quick reference guides", "Proposals", "Newsletters", "Website content", "User assistance guides (FAQs)"));

//      Program start here --->

        System.out.println();
        System.out.println("Hello , This is a program for those who can't figure out what job track they want from CSE student to another .");
        System.out.println();
        System.out.println("Computer Science has such wonderful fields ,everyone has different preferences & We are trying to help .");
        System.out.println();

//      Getting users attention

        System.out.println("Choose what inspires you the most : ");
        System.out.println();

        System.out.println("1- Life is worthless as long as Problem solving , Data structures and Algorithms , Designing exist .");
        System.out.println();

        System.out.println("2- Good Data Analysis and Decision Making = bright FUTURE ! ");
        System.out.println();

        System.out.println("3- Feeling excited about Monitoring,Troubleshooting and Maintenance ? ");
        System.out.println();

        System.out.println("4- A Natural Strategist ,NO WORRIES ! Everything is under control . ");
        System.out.println();

        System.out.println("5- The harmony between coding and designing is something to live for ! ");
        System.out.println();

        System.out.println("6- An App for everything , Let's make some ! ");
        System.out.println();

        System.out.println("7- Animation is a breath taking , such a piece of ART .");
        System.out.println();

        System.out.println("8- Creativity is a wonderful concept , A dream come TRUE .");
        System.out.println();

        System.out.println("9- Because humankind overthinks TOO MUCH , Everything is Descriptive .");
        System.out.println();

        System.out.println("Press 10 to exit .");
        System.out.println();

//      Allow user to try different choices

        do {


            Scanner scanner = new Scanner(System.in);
            int userChoice = scanner.nextInt();

            switch (userChoice) {

                case 1:
                    System.out.println("Job Title : " + softwaredeveloper.getTitle());
                    System.out.println("Description : " + softwaredeveloper.getDescription());
                    System.out.println("Required skills : " + softwaredeveloper.getRequiredSkills());
                    System.out.println("Average salary : " + softwaredeveloper.getAverageSalary());
                    System.out.println("Development languages : " + softwaredeveloper.getDevelopmentLanguages());
                    System.out.println("Development frameworks : " + softwaredeveloper.getDevelopmentFrameworks());
                    System.out.println();

                    URL Sdurl;
                    try {
                        Sdurl = new URL("https://www.coursera.org/career-academy/roles/back-end-developer");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Sdurl);

                    break;

                case 2:
                    System.out.println("Job Title : " + dataScientist.getTitle());
                    System.out.println("Description : " + dataScientist.getDescription());
                    System.out.println("Required skills : " + dataScientist.getRequiredSkills());
                    System.out.println("Average salary : " + dataScientist.getAverageSalary());
                    System.out.println("ML Algo : " + dataScientist.getMachineLearningAlgorithms());
                    System.out.println("Data analysis tool : " + dataScientist.getDataAnalysisTools());
                    System.out.println();

                    URL Dsurl;
                    try {
                        Dsurl = new URL("https://www.coursera.org/career-academy/roles/data-scientist");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Dsurl);


                    break;

                case 3:
                    System.out.println("Job Title : " + networkEngineer.getTitle());
                    System.out.println("Description : " + networkEngineer.getDescription());
                    System.out.println("Required skills : " + networkEngineer.getRequiredSkills());
                    System.out.println("Average salary : " + networkEngineer.getAverageSalary());
                    System.out.println("Network protocols : " + networkEngineer.getNetworkProtocols());
                    System.out.println("Security configuration tools : " + networkEngineer.getSecurityConfigurationTools());
                    System.out.println();

                    URL Neurl;
                    try {
                        Neurl = new URL("https://www.coursera.org/career-academy/roles/network-engineer");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Neurl);


                    break;

                case 4:
                    System.out.println("Job Title : " + cybersecurityAnalyst.getTitle());
                    System.out.println("Description : " + cybersecurityAnalyst.getDescription());
                    System.out.println("Required skills : " + cybersecurityAnalyst.getRequiredSkills());
                    System.out.println("Average salary : " + cybersecurityAnalyst.getAverageSalary());
                    System.out.println("Vulnerability assessment tools : " + cybersecurityAnalyst.getVulnerabilityAssessmentTools());
                    System.out.println("Threat detection techniques : " + cybersecurityAnalyst.getThreatDetectionTechniques());
                    System.out.println();

                    URL Csurl;
                    try {
                        Csurl = new URL("https://www.coursera.org/career-academy/roles/cybersecurity-analyst");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Csurl);


                    break;

                case 5:
                    System.out.println("Job Title : " + webDeveloper.getTitle());
                    System.out.println("Description : " + webDeveloper.getDescription());
                    System.out.println("Required skills : " + webDeveloper.getRequiredSkills());
                    System.out.println("Average salary : " + webDeveloper.getAverageSalary());
                    System.out.println("Front-End : " + webDeveloper.getFrontEndTechnologies());
                    System.out.println("Back-End : " + webDeveloper.getBackEndTechnologies());
                    System.out.println();

                    URL Wdurl;
                    try {
                        Wdurl = new URL("https://www.geeksforgeeks.org/web-development/#courses");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Wdurl);


                    break;

                case 6:
                    System.out.println("Job Title : " + mobileDeveloper.getTitle());
                    System.out.println("Description : " + mobileDeveloper.getDescription());
                    System.out.println("Required skills : " + mobileDeveloper.getRequiredSkills());
                    System.out.println("Average salary : " + mobileDeveloper.getAverageSalary());
                    System.out.println();

                    URL Mdurl;
                    try {
                        Mdurl = new URL("https://www.coursera.org/career-academy/roles/android-developer");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Mdurl);


                    break;

                case 7:
                    System.out.println("Job Title : " + gameDeveloper.getTitle());
                    System.out.println("Description : " + gameDeveloper.getDescription());
                    System.out.println("Required skills : " + gameDeveloper.getRequiredSkills());
                    System.out.println("Average salary : " + gameDeveloper.getAverageSalary());
                    System.out.println("Development tools : " + gameDeveloper.getDevelopmentTools());
                    System.out.println("Game engine : " + gameDeveloper.getGameEngine());
                    System.out.println();

                    URL Gurl;
                    try {
                        Gurl = new URL("https://www.udemy.com/courses/development/game-development/");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Gurl);


                    break;

                case 8:
                    System.out.println("Job Title : " + userExperienceDesigner.getTitle());
                    System.out.println("Description : " + userExperienceDesigner.getDescription());
                    System.out.println("Required skills : " + userExperienceDesigner.getRequiredSkills());
                    System.out.println("Average salary : " + userExperienceDesigner.getAverageSalary());
                    System.out.println("Design Principles : " + userExperienceDesigner.getDesignPrinciples());
                    System.out.println("Research Methodologies : " + userExperienceDesigner.getUserResearchMethodologies());
                    System.out.println();

                    URL UXurl;
                    try {
                        UXurl = new URL("https://www.coursera.org/career-academy/roles/ux-designer");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(UXurl);


                    break;

                case 9:
                    System.out.println("Job Title : " + technicalWriter.getTitle());
                    System.out.println("Description : " + technicalWriter.getDescription());
                    System.out.println("Required skills : " + technicalWriter.getRequiredSkills());
                    System.out.println("Average salary : " + technicalWriter.getAverageSalary());
                    System.out.println("Communication skills : " + technicalWriter.getCommunicationSkills());
                    System.out.println("Documentation standards : " + technicalWriter.getDocumentationStandards());
                    System.out.println();

                    URL Turl;
                    try {
                        Turl = new URL("https://www.udemy.com/courses/search/?q=technical+writing&src=sac&kw=techn");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Turl);


                    break;

                case 10:
                    System.out.println("Exit , hope we Helped .");
                    System.out.println("Best Luck ! ");
                    return;// This will exit the entire program

                default:
                    throw new IllegalStateException("Unexpected value: " + userChoice);
            }
            //break;

        } while (true);

    }
}