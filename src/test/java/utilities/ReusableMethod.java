package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPageElement;
import java.time.Duration;
import java.util.Set;

public class ReusableMethod {

    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }

    }

    public static String openNewTabAndSwitch(String url) {
        // Store the current window handle
        String currentTab = Driver.getDriver().getWindowHandle();

        // Open a new tab with the given URL
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('" + url + "', '_blank');");

        // Wait for the new tab to appear
        Set<String> handles = Driver.getDriver().getWindowHandles();
        while (handles.size() == 1) {
            handles = Driver.getDriver().getWindowHandles();
        }

        // Switch to the new tab
        for (String handle : handles) {
            if (!handle.equals(currentTab)) {
                Driver.getDriver().switchTo().window(handle);
                break;
            }
        }

        // Return the handle of the original tab
        return currentTab;
    }

    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}



