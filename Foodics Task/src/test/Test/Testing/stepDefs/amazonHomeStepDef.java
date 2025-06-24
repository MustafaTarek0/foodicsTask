package Testing.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Testing.Pages.amazonHomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class amazonHomeStepDef {

    amazonHomePage home = new amazonHomePage();

    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    @Given("user navigate to amazon EG")
    public void userNavigateToAmazon() throws InterruptedException {
        Hooks.driver.get("https://www.amazon.eg/?language=en_AE");
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.amazon.eg/?language=en_AE");
    }


    @When("user clicks on all side menu")
    public void userClicksOnAllSideMenu() throws InterruptedException {
        home.getSideMenu().click();
    }



    @And("user clicks on see all")
    public void userClicksOnSeeAll() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(home.getSeeAll()));
        home.getSeeAll().click();
    }

    @And("user clicks on video games {string}")
    public void userClicksOnVideoGames(String category) throws InterruptedException {
        home.clickMenuItemByText(category);

    }
    @And("user clicks on all video games {string}")
    public void userClicksOnAllVideoGames(String subCategory) throws InterruptedException {

        home.clickMenuItemByText(subCategory);


    }

    @Then("user verifies that he is navigated to all video games page")
    public void userVerifiesThatHeIsNavigatedToAllVideoGamesPage() throws InterruptedException {
    }


    @Given("user click on sign in")
    public void userClickOnSignIn() {
        home.getSignIn().click();
    }



}
