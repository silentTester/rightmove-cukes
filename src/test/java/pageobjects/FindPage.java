package pageobjects;

import org.openqa.selenium.By;

public class FindPage {

    public By searchTitleHeader = By.className("searchTitle-heading");
    public By searchResultSelector = By.xpath("//*[@class='l-searchResult is-list']");
    public By searchResultCountTotal = By.className("searchHeader-resultCount");
}
