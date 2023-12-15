import java.util.List;

public class GameDeveloper extends JobTrack {
    private String gameEngine;
    private List<String> developmentTools;

    public GameDeveloper() {
        super();
    }

    public String getGameEngine() {
        return gameEngine;
    }

    public void setGameEngine(String gameEngine) {
        this.gameEngine = gameEngine;
    }

    public List<String> getDevelopmentTools() {
        return developmentTools;
    }

    public void setDevelopmentTools(List<String> developmentTools) {
        this.developmentTools = developmentTools;
    }

    // Getters and setters
}