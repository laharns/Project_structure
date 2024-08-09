package projectStructure.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    /*private static Properties properties = new Properties();

    static {
        try {
            FileInputStream inputStream = new FileInputStream("D:/Java_projects/Freamwork-Project-structure-demo/src/test/java/projectStructure/testdata.Properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }*/
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

