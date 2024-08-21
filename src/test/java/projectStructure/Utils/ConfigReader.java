package projectStructure.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    Properties properties;

    public ConfigReader(String filePath) {
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
    public WebElement getElement(WebDriver driver, String key) {
        String locatorValue = properties.getProperty(key);

        if (locatorValue == null) {
            throw new RuntimeException("Locator not found in properties file for key: " + key);
        }

        if (key.endsWith(".xpath")) {
            return driver.findElement(By.xpath(locatorValue));
        } else if (key.endsWith(".id")) {
            return driver.findElement(By.id(locatorValue));
        } else {
            throw new RuntimeException("Unsupported locator type for key: " + key);
        }
    }
    public boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(properties.getProperty(key));
    }
}

