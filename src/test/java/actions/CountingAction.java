package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CountingAction {

    private static WebDriver webDriver;

    public static int numberOf(By searchResultSelector) {
        return webDriver.findElements(searchResultSelector).size();
    }

    public static void setWebDriver(WebDriver webDriver) {
        CountingAction.webDriver = webDriver;
    }
}
