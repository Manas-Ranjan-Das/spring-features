package others;

import java.util.Properties;

public class PropertiesWrapper {
    Properties properties ;
    public PropertiesWrapper( Properties properties) {
        this.properties = properties;
    }

    public PropertiesWrapper() {
        super();
    }
    public Properties getProperties() {
        return properties;
    }
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
