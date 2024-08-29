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

 // Highlight Element (for debugging)
    public void highlightElement(By locator) {
    WebElement element = driver.findElement(locator);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

// Clear Text Field
    public void clearTextField(By locator) {
    WebElement element = driver.findElement(locator);
    element.clear();
    }

// Check if Element Exists
    public boolean isElementPresent(By locator) {
        try {
         driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Get Page Source
    public String getPageSource() {
        return driver.getPageSource();
    }

    //Wait for Element to Contain Text
    public void waitForElementToContainText(By locator, String text, int timeoutInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    // Get Current URL
    public String getCurrentUrl() {
    return driver.getCurrentUrl();
    }

//Navigate to URL
public void navigateToUrl(String url) {
    driver.navigate().to(url);
}

//  Check if Alert is Present
public boolean isAlertPresent() {
    try {
        driver.switchTo().alert();
        return true;
    } catch (NoAlertPresentException e) {
        return false;
    }
}

//Dismiss Alert
public void dismissAlert() {
    Alert alert = driver.switchTo().alert();
    alert.dismiss();
}


//Upload File Using Robot Class (for non-input elements)
public void uploadFileWithRobot(String filePath) throws AWTException {
    StringSelection selection = new StringSelection(filePath);
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

    Robot robot = new Robot();

    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);

    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
}

//Capture Screenshot of Element
public void captureElementScreenshot(By locator, String filePath) {
    WebElement element = driver.findElement(locator);
    File screenshot = element.getScreenshotAs(OutputType.FILE);
    try {
        FileUtils.copyFile(screenshot, new File(filePath));
    } catch (IOException e) {
        e.printStackTrace();
    }
}

//Switch to Parent Window
public void switchToParentWindow() {
    String parentWindow = driver.getWindowHandle();
    for (String windowHandle : driver.getWindowHandles()) {
        if (!windowHandle.equals(parentWindow)) {
            driver.switchTo().window(parentWindow);
        }
    }
}

//witch to Child Window
public void switchToChildWindow() {
    String parentWindow = driver.getWindowHandle();
    for (String windowHandle : driver.getWindowHandles()) {
        if (!windowHandle.equals(parentWindow)) {
            driver.switchTo().window(windowHandle);
        }
    }
}

//Double Click Element
public void doubleClickElement(By locator) {
    Actions actions = new Actions(driver);
    WebElement element = driver.findElement(locator);
    actions.doubleClick(element).perform();
}

//Right Click (Context Click)
public void rightClickElement(By locator) {
    Actions actions = new Actions(driver);
    WebElement element = driver.findElement(locator);
    actions.contextClick(element).perform();
}

//Wait for Element to be Stale
public void waitForElementToBeStale(By locator, int timeoutInSeconds) {
    WebElement element = driver.findElement(locator);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    wait.until(ExpectedConditions.stalenessOf(element));
}

// Check if Element is Read-Only
public boolean isElementReadOnly(By locator) {
    WebElement element = driver.findElement(locator);
    return element.getAttribute("readonly") != null;
}

// Zoom In/Out Using JavaScript
public void zoomInOut(int zoomPercentage) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("document.body.style.zoom='" + zoomPercentage + "%'");
}

//Handle Browser Authentication
public void handleBrowserAuthentication(String username, String password) {
    String credentials = username + ":" + password;
    String authUrl = "https://" + credentials + "@" + driver.getCurrentUrl().replace("https://", "");
    driver.get(authUrl);
}

//Wait for Number of Windows to be (For Handling Pop-Ups)
public void waitForNumberOfWindowsToBe(int expectedNumberOfWindows, int timeoutInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows));
}

// Wait for URL to Contain
public void waitForUrlToContain(String urlFraction, int timeoutInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    wait.until(ExpectedConditions.urlContains(urlFraction));
}

    */

}
