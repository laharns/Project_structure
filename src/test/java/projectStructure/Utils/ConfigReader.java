package projectStructure.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    Properties properties;

    public ConfigReader() {
        try {
            FileInputStream inputStream = new FileInputStream("src/test/java/projectStructure/testdata.Properties");
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(properties.getProperty(key));
    }
}

