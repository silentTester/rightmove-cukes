package pageobjects;

import org.openqa.selenium.By;

public class IndexPage {

    public By pageTitle = By.id("rm-site-logo");
    public By searchLocation = By.id("searchLocation");

    public By button(String buttonType) {
        return By.id(buttonType);
    }

}
