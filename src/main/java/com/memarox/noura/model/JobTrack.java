package com.memarox.noura.model;

import java.util.List;

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

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<String> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getDevelopmentLanguages() {
        return developmentLanguages;
    }

    public void setDevelopmentLanguages(List<String> developmentLanguages) {
        this.developmentLanguages = developmentLanguages;
    }

    public List<String> getDevelopmentFrameworks() {
        return developmentFrameworks;
    }

    public void setDevelopmentFrameworks(List<String> developmentFrameworks) {
        this.developmentFrameworks = developmentFrameworks;
    }

    public List<String> getMachineLearningAlgorithms() {
        return machineLearningAlgorithms;
    }

    public void setMachineLearningAlgorithms(List<String> machineLearningAlgorithms) {
        this.machineLearningAlgorithms = machineLearningAlgorithms;
    }

    public List<String> getDataAnalysisTools() {
        return dataAnalysisTools;
    }

    public void setDataAnalysisTools(List<String> dataAnalysisTools) {
        this.dataAnalysisTools = dataAnalysisTools;
    }

    public List<String> getNetworkProtocols() {
        return networkProtocols;
    }

    public void setNetworkProtocols(List<String> networkProtocols) {
        this.networkProtocols = networkProtocols;
    }

    public List<String> getSecurityConfigurationTools() {
        return securityConfigurationTools;
    }

    public void setSecurityConfigurationTools(List<String> securityConfigurationTools) {
        this.securityConfigurationTools = securityConfigurationTools;
    }

    public List<String> getVulnerabilityAssessmentTools() {
        return vulnerabilityAssessmentTools;
    }

    public void setVulnerabilityAssessmentTools(List<String> vulnerabilityAssessmentTools) {
        this.vulnerabilityAssessmentTools = vulnerabilityAssessmentTools;
    }

    public List<String> getThreatDetectionTechniques() {
        return threatDetectionTechniques;
    }

    public void setThreatDetectionTechniques(List<String> threatDetectionTechniques) {
        this.threatDetectionTechniques = threatDetectionTechniques;
    }

    public List<String> getFrontEndTechnologies() {
        return frontEndTechnologies;
    }

    public void setFrontEndTechnologies(List<String> frontEndTechnologies) {
        this.frontEndTechnologies = frontEndTechnologies;
    }

    public List<String> getBackEndTechnologies() {
        return backEndTechnologies;
    }

    public void setBackEndTechnologies(List<String> backEndTechnologies) {
        this.backEndTechnologies = backEndTechnologies;
    }

    public List<String> getDevelopmentTools() {
        return developmentTools;
    }

    public void setDevelopmentTools(List<String> developmentTools) {
        this.developmentTools = developmentTools;
    }

    public String getGameEngine() {
        return gameEngine;
    }

    public void setGameEngine(String gameEngine) {
        this.gameEngine = gameEngine;
    }

    public List<String> getDesignPrinciples() {
        return designPrinciples;
    }

    public void setDesignPrinciples(List<String> designPrinciples) {
        this.designPrinciples = designPrinciples;
    }

    public List<String> getUserResearchMethodologies() {
        return userResearchMethodologies;
    }

    public void setUserResearchMethodologies(List<String> userResearchMethodologies) {
        this.userResearchMethodologies = userResearchMethodologies;
    }

    public List<String> getCommunicationSkills() {
        return communicationSkills;
    }

    public void setCommunicationSkills(List<String> communicationSkills) {
        this.communicationSkills = communicationSkills;
    }

    public List<String> getDocumentationStandards() {
        return documentationStandards;
    }

    public void setDocumentationStandards(List<String> documentationStandards) {
        this.documentationStandards = documentationStandards;
    }

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