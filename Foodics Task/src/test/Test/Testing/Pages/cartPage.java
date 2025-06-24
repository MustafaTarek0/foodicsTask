package Testing.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class cartPage extends pageBase{


    @FindBy(id = "sc-active-items-header")
    WebElement shoppingCartLabel;
    @FindBy(css = "input[name='proceedToRetailCheckout']")
    WebElement proceedToBuyBtn;
    @FindBy(css = "div.sc-list-item")
    List<WebElement> cartList;


    public WebElement getShoppingCartLabel() {
        return shoppingCartLabel;
    }
    public List<WebElement> getCartList() {
        return cartList;
    }

    public WebElement getProceedToBuyBtn() {
        return proceedToBuyBtn;
    }


}
