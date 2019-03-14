package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TypingAction {

    private static WebDriver webDriver;

    public static void on(By pageElement, String text) {
        webDriver.findElement(pageElement).click();
        webDriver.findElement(pageElement).clear();
        webDriver.findElement(pageElement).sendKeys(text);
    }

    public static void setWebDriver(WebDriver webDriver) {
        TypingAction.webDriver = webDriver;
    }

}
