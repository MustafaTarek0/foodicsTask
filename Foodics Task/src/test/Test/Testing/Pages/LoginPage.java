package Testing.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends pageBase{

    @FindBy(id = "ap_email_login")
    WebElement emailOrMobileNumber;

    @FindBy(css = "input.a-button-input[type='submit'][aria-labelledby='continue-announce']")
    WebElement continueButton;
    @FindBy(id = "ap_password")
    WebElement password;
    @FindBy(id = "signInSubmit")
    WebElement signIn;
    public WebElement getEmailOrMobileNumber() {
        return emailOrMobileNumber;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getSignIn() {
        return signIn;
    }
}
