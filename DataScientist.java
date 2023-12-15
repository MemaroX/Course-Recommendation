import java.util.List;

public class DataScientist extends JobTrack{
    private List<String> machineLearningAlgorithms;
    private List<String> dataAnalysisTools;

    public DataScientist() {
        super();
    }

    public List<String> getMachineLearningAlgorithms(){

        return machineLearningAlgorithms;
    }

    public void setMachineLearningAlgorithms(List<String> machineLearningAlgorithms) {
        this.machineLearningAlgorithms = machineLearningAlgorithms;
    }

    public List<String> getDataAnalysisTools(){

        return dataAnalysisTools;
    }

    public void setDataAnalysisTools(List<String> dataAnalysisTools) {
        this.dataAnalysisTools = dataAnalysisTools;
    }

}
