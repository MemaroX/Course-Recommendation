import java.util.List;

public class JobTrack {
    private String title;
    private String description;
    private List<String> requiredSkills;
    private double averageSalary;


    public String getTitle(){
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }



    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<String> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(int i) {
        this.averageSalary = averageSalary;
    }
}


