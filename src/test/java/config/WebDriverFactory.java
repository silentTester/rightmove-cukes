package config;

import actions.ClickingAction;
import actions.CountingAction;
import actions.ReadingAction;
import actions.TypingAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    private final String WEB_DRIVER = "webdriver.chrome.driver";
    private final String WEB_DRIVER_PATH = "/usr/local/bin/chromedriver";


    public WebDriver getWebDriver() {
        System.setProperty(WEB_DRIVER, WEB_DRIVER_PATH);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        createActions(driver);
        return driver;
    }

    private void createActions(WebDriver webDriver) {
        TypingAction.setWebDriver(webDriver);
        ClickingAction.setWebDriver(webDriver);
        ReadingAction.setWebDriver(webDriver);
        CountingAction.setWebDriver(webDriver);
    }

}
