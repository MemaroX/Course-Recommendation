import java.util.List;

public class NetworkEngineer extends JobTrack{
    private List<String> networkProtocols;
    private List<String> securityConfigurationTools;

    public NetworkEngineer() {
        super();
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


}
