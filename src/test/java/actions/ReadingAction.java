package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReadingAction {

    private static WebDriver webDriver;

    public static String ofAttribute(By selector, String attributeName) {
       return  webDriver.findElement(selector).getAttribute(attributeName);
    }

    public static String getText(By selector) {
        return  webDriver.findElement(selector).getText();
    }

    public static void setWebDriver(WebDriver webDriver) {
        ReadingAction.webDriver = webDriver;
    }

}
