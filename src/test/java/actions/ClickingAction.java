package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickingAction {

    private static WebDriver webDriver;

    public static void on(By button) {
        webDriver.findElement(button).click();
    }

    public static void setWebDriver(WebDriver webDriver) {
        ClickingAction.webDriver = webDriver;
    }

}
