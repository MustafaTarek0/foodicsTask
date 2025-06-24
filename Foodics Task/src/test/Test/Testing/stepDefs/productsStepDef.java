package Testing.stepDefs;

import Testing.Pages.LoginPage;
import Testing.Pages.productsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class productsStepDef {
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

    productsPage products = new productsPage();

    @When("user clicks on free shipping checkbox")
    public void userClicksOnFreeShippingCheckbox() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(products.getFreeShipping()));
        products.getFreeShipping().click();

    }

    @Then("user clicks on new condition")
    public void userClicksOnNewCondition() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(products.getConditionNew()));
        products.getConditionNew().click();

    }
    @And("user clicks on sort by dropdown list")
    public void userClicksOnSortByDropdownList() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(  products.getSortByDropDown()));
        products.getSortByDropDown().click();


    }

    @And("user sorts by high to low price {string}")
    public void userSortsByHighToLowPrice(String sortKey) throws InterruptedException {

        products.clickSortByText(sortKey);

    }


    @And("^user randomly selects a product below (\\d+) and if not available he will click next page then repeat searching then clicks on cart to make sure that it's already added$")
    public void userRandomlySelectAProductBelowPriceAndIfNotAvailableHeWillClickNextPageThenRepeatSearchingThenClicksOnCartToMakeSureThatIsTAlreadyAdded(int price) throws InterruptedException {
        int beforeCount = products.getCartCount();
System.out.println(beforeCount);
        int addedItems = products.findAndAddItemUnderPrice(price);
        Thread.sleep(2000);
        int afterCount = products.getCartCount();
        System.out.println(afterCount);
        Assert.assertEquals(afterCount, beforeCount + addedItems,
                "Cart count mismatch after adding items.");
    }


    @And("user clicks on add to cart")
    public void userClicksOnAddToCart() {
        wait.until(ExpectedConditions.visibilityOf( products.getCartNavigate()));
        products.getCartNavigate().click();
    }


}
