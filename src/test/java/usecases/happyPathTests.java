package usecases;

import actions.ClickingAction;
import actions.CountingAction;
import actions.ReadingAction;
import actions.TypingAction;
import config.WebDriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.IndexPage;
import pageobjects.ResultsPage;
import pageobjects.SalesPage;

import static org.junit.Assert.assertEquals;

public class happyPathTests {

    private final String EXPECTED_FOR_SALE = "Properties For Sale in ";
    private final String RIGHTMOVE_PAGE_TITLE = "Rightmove property search for flats and houses for sale and for rent";
    private final String TEST_URL = "http://www.rightmove.co.uk";
    private WebDriver webDriver = new WebDriverFactory().getWebDriver();
    private IndexPage indexPage = new IndexPage();
    private SalesPage salesPage = new SalesPage();
    private ResultsPage resultsPage = new ResultsPage();

    @Before
    private void navigateToURL() {
        webDriver.navigate().to(TEST_URL);
        assertEquals(RIGHTMOVE_PAGE_TITLE,
                ReadingAction.ofAttribute(indexPage.pageTitle, "alt"));
    }

    @After
    private void tearDown() {
        webDriver.quit();
    }

    @Given("user enters property {string}")
    public void user_input_postcode(String postCode) {
        navigateToURL();
        TypingAction.on(indexPage.searchLocation, postCode);
    }

    @When("user clicks button {string}")
    public void user_clicks_button(String buttonType) {
        ClickingAction.on(indexPage.button(buttonType));
    }

    @And("user clicks find properties")
    public void user_clicks_find_properties() {
        ClickingAction.on(salesPage.findButton);
    }

    @Then("list of properties for {string} in {string}")
    public void list_homes_for(String buttonType, String postCode) {
        assertEquals(EXPECTED_FOR_SALE + postCode,
                ReadingAction.getText(resultsPage.searchTitleHeader));
    }

    @And("number of properties found is {int}")
    public void number_properties(int nosProperties) {
        assertEquals(nosProperties + "",
                ReadingAction.getText(resultsPage.searchResultCountTotal));

        assertEquals(nosProperties, CountingAction.numberOf(resultsPage.searchResultSelector));
        tearDown();
    }


}
