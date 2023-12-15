import java.util.List;

public class SoftwareDeveloper extends JobTrack{
    private List<String> developmentLanguages;
    private List<String> developmentFrameworks;
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


}
