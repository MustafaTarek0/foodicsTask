package Testing.stepDefs;

import Testing.Pages.LoginPage;
import io.cucumber.java.en.And;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginStepDef {
    LoginPage login = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

    @And("user insert phone number {string}")
    public void userInsertPhoneNumber(String phoneNumber) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(login.getEmailOrMobileNumber()));
        login.getEmailOrMobileNumber().sendKeys(phoneNumber);
    }

    @And("user clicks continue")
    public void userClicksContinue() {
        wait.until(ExpectedConditions.visibilityOf( login.getContinueButton()));
        login.getContinueButton().click();
    }

    @And("user insert password {string}")
    public void userInsertPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf( login.getPassword()));
        login.getPassword().sendKeys(password);
    }

    @And("user clicks sign in")
    public void userClicksSignIn() {
        wait.until(ExpectedConditions.visibilityOf(login.getSignIn()));
        login.getSignIn().click();
    }
}
