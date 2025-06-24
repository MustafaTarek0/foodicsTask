package Testing.stepDefs;

import Testing.Pages.cartPage;
import Testing.Pages.checkOutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class checkOutStepDef {
    checkOutPage checkOut = new checkOutPage();
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

    @Then("user validates that change delivery address is visible")
    public void userValidatesThatChangeDeliveryAddressIsVisible() {
        wait.until(ExpectedConditions.visibilityOf(checkOut.getChangeAddress()));
        Assert.assertTrue(checkOut.getChangeAddress().isDisplayed());
    }

    @When("user clicks on change delivery address button")
    public void userClicksOnChangeDeliveryAddressButton() {
        wait.until(ExpectedConditions.visibilityOf(checkOut.getChangeAddress()));
        checkOut.getChangeAddress().click();
    }
    @Then("add new delivery address button should be displayed")
    public void addNewDeliveryAddressButtonShouldBeDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(checkOut.getAddNewDeliveryAddressBtn()));

    }

    @When("user clicks on new delivery address button")
    public void userClicksOnNewDeliveryAddressButton() {
        checkOut.getAddNewDeliveryAddressBtn().click();
    }

    @And("user insert full name {string}")
    public void userInsertFullName(String fullName) {
        wait.until(ExpectedConditions.visibilityOf(checkOut.getAddressFullName()));
        checkOut.getAddressFullName().sendKeys(fullName);
    }

    @And("user insert full mobileNumber {string}")
    public void userInsertFullMobileNumber(String mobileNumber) {
        checkOut.getAddressPhoneNumber().sendKeys(mobileNumber);
    }
    @And("user insert street name {string}")
    public void userInsertStreetName(String streetName) {
        checkOut.getAddressLine1().sendKeys(streetName);
    }

    @And("user insert building name {string}")
    public void userInsertBuildingName(String buildingName) {
        checkOut.getBuildingNumber().sendKeys(buildingName);
    }

    @And("user insert city {string}")
    public void userInsertCity(String city) {
        checkOut.getCity().sendKeys(city);

        checkOut.getBuildingNumber().click();
    }

    @And("user insert district {string}")
    public void userInsertDistrict(String district) {
        wait.until(ExpectedConditions.visibilityOf(checkOut.getDistrict()));

        checkOut.getDistrict().sendKeys(district);
    }

    @And("user insert Governorate {string}")
    public void userInsertGovernorate(String Governorate) {

        checkOut.getGovernorate().sendKeys(Governorate);
    }

    @And("user clicks on use this address button")
    public void userClicksOnUseThisAddressButton() {

        ((JavascriptExecutor) Hooks.driver).executeScript("arguments[0].click();", checkOut.getUseAddressBtn());
    }

    @Then("user validates that value payment method is visible")
    public void userValidatesThatValuePaymentMethodIsVisible() {
        wait.until(ExpectedConditions.visibilityOf(checkOut.getValuePaymentMethod()));
        Assert.assertTrue(checkOut.getValuePaymentMethod().isDisplayed());
    }

    @When("user clicks on value payment method radio button")
    public void userClicksOnValuePaymentMethodRadioButton() {
        checkOut.getValuePaymentMethod().click();
    }
}
