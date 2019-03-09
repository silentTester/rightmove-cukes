package usecases;

import actions.ClickingAction;
import actions.CountingAction;
import actions.ReadingAction;
import actions.TypingAction;
import config.WebDriverFactory;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import pageobjects.FindPage;
import pageobjects.IndexPage;
import pageobjects.SearchPage;

import static org.junit.Assert.assertEquals;

public class happyPathTests {

    private final String RIGHTMOVE_PAGE_TITLE = "Rightmove property search for flats and houses for sale and for rent";
    private final String TEST_URL = "http://www.rightmove.co.uk";
    private static WebDriver webDriver = new WebDriverFactory().getWebDriver();
    private final String EXPECTED_FOR_SALE = "Properties For Sale in ";
    private IndexPage indexPage = new IndexPage();
    private SearchPage searchPage = new SearchPage();
    private FindPage findPage = new FindPage();

    @AfterClass
    public static void tearDown() {
        webDriver.quit();
    }

    @Before
    public void navigateToURL() {
        webDriver.navigate().to(TEST_URL);
        assertEquals(RIGHTMOVE_PAGE_TITLE,
                ReadingAction.ofAttribute(indexPage.pageTitle, "alt"));
    }

    @Given("user enters property {string}")
    public void user_input_postcode(String postCode) {
        TypingAction.on(indexPage.searchLocation, postCode);
    }

    @When("user clicks button {string}")
    public void user_clicks_button(String buttonType) {
        ClickingAction.on(indexPage.button(buttonType));
    }

    @And("user clicks find properties")
    public void user_clicks_find_properties() {
        ClickingAction.on(searchPage.findPropertiesButton);
    }

    @Then("list of properties for {string} in {string}")
    public void list_homes_for(String buttonType, String postCode) {
        assertEquals(EXPECTED_FOR_SALE + postCode,
                ReadingAction.getText(findPage.searchTitleHeader));
    }

    @And("number of properties found is {int}")
    public void number_properties(int nosProperties) {
        assertEquals(nosProperties + "",
                ReadingAction.getText(findPage.searchResultCountTotal));

        assertEquals(nosProperties, CountingAction.numberOf(findPage.searchResultSelector));
    }

    @Then("not found is displayed for {string}")
    public void not_found_displayed_for(String postCode) {
        assertEquals("'" + postCode + "' not found in the UK",
                ReadingAction.getText(searchPage.headerTitle));
    }

}
