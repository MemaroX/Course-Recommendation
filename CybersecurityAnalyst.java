import java.util.List;

public class CybersecurityAnalyst extends JobTrack {
    private List<String> vulnerabilityAssessmentTools;
    private List<String> threatDetectionTechniques;

    public CybersecurityAnalyst() {
        super();
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


}