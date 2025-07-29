package com.memarox.noura.model;

import java.util.List;

/**
 * Represents a job track with its associated details, skills, and tools.
 * This class serves as a data model for deserializing job track information from JSON.
 */
public class JobTrack {
    private String title;
    private String description;
    private List<String> requiredSkills;
    private double averageSalary;
    private String url;

    // Specific fields for Software Engineer
    private List<String> developmentLanguages;
    private List<String> developmentFrameworks;

    // Specific fields for Data Scientist
    private List<String> machineLearningAlgorithms;
    private List<String> dataAnalysisTools;

    // Specific fields for Network Engineer
    private List<String> networkProtocols;
    private List<String> securityConfigurationTools;

    // Specific fields for Cybersecurity Analyst
    private List<String> vulnerabilityAssessmentTools;
    private List<String> threatDetectionTechniques;

    // Specific fields for Web Developer
    private List<String> frontEndTechnologies;
    private List<String> backEndTechnologies;

    // Specific fields for Game Developer
    private List<String> developmentTools;
    private String gameEngine;

    // Specific fields for UX Designer
    private List<String> designPrinciples;
    private List<String> userResearchMethodologies;

    // Specific fields for Technical Writer
    private List<String> communicationSkills;
    private List<String> documentationStandards;

    /**
     * Returns the title of the job track.
     * @return The job track title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the job track.
     * @param title The job track title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the description of the job track.
     * @return The job track description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the job track.
     * @param description The job track description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the list of required skills for the job track.
     * @return A list of required skills.
     */
    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    /**
     * Sets the list of required skills for the job track.
     * @param requiredSkills A list of required skills.
     */
    public void setRequiredSkills(List<String> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    /**
     * Returns the average salary for the job track.
     * @return The average salary.
     */
    public double getAverageSalary() {
        return averageSalary;
    }

    /**
     * Sets the average salary for the job track.
     * @param averageSalary The average salary.
     */
    public void setAverageSalary(double averageSalary) {
        this.averageSalary = averageSalary;
    }

    /**
     * Returns the URL for more information about the job track.
     * @return The information URL.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the URL for more information about the job track.
     * @param url The information URL.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Returns the list of development languages for the job track (specific to Software Engineer).
     * @return A list of development languages.
     */
    public List<String> getDevelopmentLanguages() {
        return developmentLanguages;
    }

    /**
     * Sets the list of development languages for the job track (specific to Software Engineer).
     * @param developmentLanguages A list of development languages.
     */
    public void setDevelopmentLanguages(List<String> developmentLanguages) {
        this.developmentLanguages = developmentLanguages;
    }

    /**
     * Returns the list of development frameworks for the job track (specific to Software Engineer).
     * @return A list of development frameworks.
     */
    public List<String> getDevelopmentFrameworks() {
        return developmentFrameworks;
    }

    /**
     * Sets the list of development frameworks for the job track (specific to Software Engineer).
     * @param developmentFrameworks A list of development frameworks.
     */
    public void setDevelopmentFrameworks(List<String> developmentFrameworks) {
        this.developmentFrameworks = developmentFrameworks;
    }

    /**
     * Returns the list of machine learning algorithms for the job track (specific to Data Scientist).
     * @return A list of machine learning algorithms.
     */
    public List<String> getMachineLearningAlgorithms() {
        return machineLearningAlgorithms;
    }

    /**
     * Sets the list of machine learning algorithms for the job track (specific to Data Scientist).
     * @param machineLearningAlgorithms A list of machine learning algorithms.
     */
    public void setMachineLearningAlgorithms(List<String> machineLearningAlgorithms) {
        this.machineLearningAlgorithms = machineLearningAlgorithms;
    }

    /**
     * Returns the list of data analysis tools for the job track (specific to Data Scientist).
     * @return A list of data analysis tools.
     */
    public List<String> getDataAnalysisTools() {
        return dataAnalysisTools;
    }

    /**
     * Sets the list of data analysis tools for the job track (specific to Data Scientist).
     * @param dataAnalysisTools A list of data analysis tools.
     */
    public void setDataAnalysisTools(List<String> dataAnalysisTools) {
        this.dataAnalysisTools = dataAnalysisTools;
    }

    /**
     * Returns the list of network protocols for the job track (specific to Network Engineer).
     * @return A list of network protocols.
     */
    public List<String> getNetworkProtocols() {
        return networkProtocols;
    }

    /**
     * Sets the list of network protocols for the job track (specific to Network Engineer).
     * @param networkProtocols A list of network protocols.
     */
    public void setNetworkProtocols(List<String> networkProtocols) {
        this.networkProtocols = networkProtocols;
    }

    /**
     * Returns the list of security configuration tools for the job track (specific to Network Engineer).
     * @return A list of security configuration tools.
     */
    public List<String> getSecurityConfigurationTools() {
        return securityConfigurationTools;
    }

    /**
     * Sets the list of security configuration tools for the job track (specific to Network Engineer).
     * @param securityConfigurationTools A list of security configuration tools.
     */
    public void setSecurityConfigurationTools(List<String> securityConfigurationTools) {
        this.securityConfigurationTools = securityConfigurationTools;
    }

    /**
     * Returns the list of vulnerability assessment tools for the job track (specific to Cybersecurity Analyst).
     * @return A list of vulnerability assessment tools.
     */
    public List<String> getVulnerabilityAssessmentTools() {
        return vulnerabilityAssessmentTools;
    }

    /**
     * Sets the list of vulnerability assessment tools for the job track (specific to Cybersecurity Analyst).
     * @param vulnerabilityAssessmentTools A list of vulnerability assessment tools.
     */
    public void setVulnerabilityAssessmentTools(List<String> vulnerabilityAssessmentTools) {
        this.vulnerabilityAssessmentTools = vulnerabilityAssessmentTools;
    }

    /**
     * Returns the list of threat detection techniques for the job track (specific to Cybersecurity Analyst).
     * @return A list of threat detection techniques.
     */
    public List<String> getThreatDetectionTechniques() {
        return threatDetectionTechniques;
    }

    /**
     * Sets the list of threat detection techniques for the job track (specific to Cybersecurity Analyst).
     * @param threatDetectionTechniques A list of threat detection techniques.
     */
    public void setThreatDetectionTechniques(List<String> threatDetectionTechniques) {
        this.threatDetectionTechniques = threatDetectionTechniques;
    }

    /**
     * Returns the list of front-end technologies for the job track (specific to Web Developer).
     * @return A list of front-end technologies.
     */
    public List<String> getFrontEndTechnologies() {
        return frontEndTechnologies;
    }

    /**
     * Sets the list of front-end technologies for the job track (specific to Web Developer).
     * @param frontEndTechnologies A list of front-end technologies.
     */
    public void setFrontEndTechnologies(List<String> frontEndTechnologies) {
        this.frontEndTechnologies = frontEndTechnologies;
    }

    /**
     * Returns the list of back-end technologies for the job track (specific to Web Developer).
     * @return A list of back-end technologies.
     */
    public List<String> getBackEndTechnologies() {
        return backEndTechnologies;
    }

    /**
     * Sets the list of back-end technologies for the job track (specific to Web Developer).
     * @param backEndTechnologies A list of back-end technologies.
     */
    public void setBackEndTechnologies(List<String> backEndTechnologies) {
        this.backEndTechnologies = backEndTechnologies;
    }

    /**
     * Returns the list of development tools for the job track (specific to Game Developer).
     * @return A list of development tools.
     */
    public List<String> getDevelopmentTools() {
        return developmentTools;
    }

    /**
     * Sets the list of development tools for the job track (specific to Game Developer).
     * @param developmentTools A list of development tools.
     */
    public void setDevelopmentTools(List<String> developmentTools) {
        this.developmentTools = developmentTools;
    }

    /**
     * Returns the game engine for the job track (specific to Game Developer).
     * @return The game engine.
     */
    public String getGameEngine() {
        return gameEngine;
    }

    /**
     * Sets the game engine for the job track (specific to Game Developer).
     * @param gameEngine The game engine.
     */
    public void setGameEngine(String gameEngine) {
        this.gameEngine = gameEngine;
    }

    /**
     * Returns the list of design principles for the job track (specific to UX Designer).
     * @return A list of design principles.
     */
    public List<String> getDesignPrinciples() {
        return designPrinciples;
    }

    /**
     * Sets the list of design principles for the job track (specific to UX Designer).
     * @param designPrinciples A list of design principles.
     */
    public void setDesignPrinciples(List<String> designPrinciples) {
        this.designPrinciples = designPrinciples;
    }

    /**
     * Returns the list of user research methodologies for the job track (specific to UX Designer).
     * @return A list of user research methodologies.
     */
    public List<String> getUserResearchMethodologies() {
        return userResearchMethodologies;
    }

    /**
     * Sets the list of user research methodologies for the job track (specific to UX Designer).
     * @param userResearchMethodologies A list of user research methodologies.
     */
    public void setUserResearchMethodologies(List<String> userResearchMethodologies) {
        this.userResearchMethodologies = userResearchMethodologies;
    }

    /**
     * Returns the list of communication skills for the job track (specific to Technical Writer).
     * @return A list of communication skills.
     */
    public List<String> getCommunicationSkills() {
        return communicationSkills;
    }

    /**
     * Sets the list of communication skills for the job track (specific to Technical Writer).
     * @param communicationSkills A list of communication skills.
     */
    public void setCommunicationSkills(List<String> communicationSkills) {
        this.communicationSkills = communicationSkills;
    }

    /**
     * Returns the list of documentation standards for the job track (specific to Technical Writer).
     * @return A list of documentation standards.
     */
    public List<String> getDocumentationStandards() {
        return documentationStandards;
    }

    /**
     * Sets the list of documentation standards for the job track (specific to Technical Writer).
     * @param documentationStandards A list of documentation standards.
     */
    public void setDocumentationStandards(List<String> documentationStandards) {
        this.documentationStandards = documentationStandards;
    }

    /**
     * Provides a string representation of the JobTrack object.
     * @return A string containing the job track's title, description, required skills, average salary, and URL.
     */
    @Override
    public String toString() {
        return "JobTrack{" +
               "title='" + title + '\'' +
               ", description='" + description + '\'' +
               ", requiredSkills=" + requiredSkills +
               ", averageSalary=" + averageSalary +
               ", url='" + url + '\'' +
               "// Add other fields as needed for a comprehensive string representation" +
               '}';
    }
}
