package Testing.stepDefs;

import Testing.Pages.amazonHomePage;
import Testing.Pages.cartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class cartStepDef {


    cartPage cart = new cartPage();
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

    @Then("user should be navigated to cart page")
    public void userShouldBeNavigatedToCartPage() {
        Assert.assertTrue(cart.getShoppingCartLabel().isDisplayed());
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.amazon.eg/-/en/gp/cart/view.html?ref_=nav_cart");
    }

    @And("user validates that the cart isn't empty")
    public void userValidatesThatTheCartIsnTEmpty() {
        Assert.assertTrue(cart.getCartList().size() > 0, "Cart is empty — no items found.");

    }

    @And("user validate that's proceed to buy is visible")
    public void userValidateThatSProceedToBuyIsVisible() {
        Assert.assertTrue(cart.getProceedToBuyBtn().isDisplayed());
    }

    @When("user clicks on proceed to buy button")
    public void userClicksOnProceedToBuyButton() {
        cart.getProceedToBuyBtn().click();
    }



}
