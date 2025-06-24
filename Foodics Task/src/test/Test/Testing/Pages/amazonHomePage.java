package Testing.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class amazonHomePage extends pageBase{

    @FindBy(id = "nav-hamburger-menu")
    WebElement sideMenu;

    @FindBy(css = "a.hmenu-item.hmenu-compressed-btn")
    WebElement seeAll;

    @FindBy(css = "a.hmenu-item")
    List<WebElement> sideMenuItems;

    @FindBy(css = "a[data-nav-ref='nav_ya_signin']")
    WebElement signIn;


    public WebElement getSideMenu() {
        return sideMenu;
    }

    public WebElement getSeeAll() {
        return seeAll;
    }

    public void clickMenuItemByText(String itemText) {
        clickMenuItemByText(itemText, sideMenuItems);
    }
    public WebElement getSignIn() {
        return signIn;
    }

}
