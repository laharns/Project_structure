package projectStructure.Common_method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class commonMethod {
    private WebDriver driver;

   public commonMethod(WebDriver driver) {
        this.driver = driver;
    }
    public void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    // Send Keys Method
    public void enterText(By locator, String text) {
       WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }
    /*
    // Get Text Method
    public String getElementText(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    // Wait for Element to be Visible
    public void waitForElementVisible(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    // Select Dropdown by Visible Text
    public void selectDropdownByVisibleText(By locator, String visibleText) {
        WebElement dropdown = driver.findElement(locator);
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }

    // Switch to Frame
    public void switchToFrame(By locator) {
        WebElement frame = driver.findElement(locator);
        driver.switchTo().frame(frame);
    }
    // Switch to Default Content
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
    // Accept Alert
    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    // JavaScript Click (In case normal click fails)
    public void javascriptClick(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    // Get Attribute Value
    public String getElementAttribute(By locator, String attribute) {
        WebElement element = driver.findElement(locator);
        return element.getAttribute(attribute);
    }

    // Wait for Element to be Clickable
    public void waitForElementToBeClickable(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Get Current Page Title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Wait for Element to be Present
    public void waitForElementPresence(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Move to Element (Hover)
    public void moveToElement(By locator) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
    }

    // Drag and Drop
    public void dragAndDrop(By sourceLocator, By targetLocator) {
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(sourceLocator);
        WebElement target = driver.findElement(targetLocator);
        actions.dragAndDrop(source, target).perform();
    }

    // Take Screenshot
    public void takeScreenshot(String filePath) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Scroll to Element
    public void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Scroll to Bottom of Page
    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    // Get All Options from Dropdown
    public List<String> getAllDropdownOptions(By locator) {
        WebElement dropdown = driver.findElement(locator);
        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();
        List<String> optionTexts = new ArrayList<>();
        for (WebElement option : options) {
            optionTexts.add(option.getText());
        }
        return optionTexts;
    }

    // Check if Element is Displayed
    public boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Check if Element is Enabled
    public boolean isElementEnabled(By locator) {
        WebElement element = driver.findElement(locator);
        return element.isEnabled();
    }

    // Check if Element is Selected
    public boolean isElementSelected(By locator) {
        WebElement element = driver.findElement(locator);
        return element.isSelected();
    }

    // Get CSS Value
    public String getElementCssValue(By locator, String cssProperty) {
        WebElement element = driver.findElement(locator);
        return element.getCssValue(cssProperty);
    }

    // Switch to Window by Title
    public void switchToWindowByTitle(String windowTitle) {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(windowTitle)) {
                break;
            }
        }
    }

    // Close All Other Windows Except Main
    public void closeAllOtherWindows() {
        String mainWindowHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindowHandle);
    }

    // Wait for Element to be Invisible
    public void waitForElementToBeInvisible(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // Wait for Page to Load Completely
    public void waitForPageLoadComplete(int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    // Upload File
    public void uploadFile(By locator, String filePath) {
        WebElement fileInput = driver.findElement(locator);
        fileInput.sendKeys(filePath);
    }

    // Refresh Page
    public void refreshPage() {
        driver.navigate().refresh();
    }

    // Navigate Back
    public void navigateBack() {
        driver.navigate().back();
    }

    // Navigate Forward
    public void navigateForward() {
        driver.navigate().forward();
    }
    */

}
