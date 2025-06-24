package Testing.Pages;

import Testing.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class productsPage extends pageBase {
    @FindBy(css = "i.a-icon.a-icon-checkbox")
    WebElement freeShipping;
    @FindBy(css = "a.a-link-normal[href*='p_n_condition-type']")
    WebElement conditionNew;
    @FindBy(id = "a-autoid-0-announce")
    WebElement sortByDropDown;
    @FindBy(css = "li.a-dropdown-item a.a-dropdown-link")
    List<WebElement> sortByList;
    @FindBy(css = "div.s-result-item[data-asin]:not([data-asin=''])")
    List<WebElement> productsList;
    @FindBy(id ="nav-cart-count")
    WebElement cartCount;
    @FindBy(id = "nav-cart")
    WebElement cartNavigate;
    public void clickSortByText(String itemText) {
        clickMenuItemByText(itemText, sortByList);
    }
    public WebElement getFreeShipping() {
        return freeShipping;
    }

    public WebElement getConditionNew() {
        return conditionNew;
    }

    public WebElement getSortByDropDown() {
        return sortByDropDown;
    }
    public int findAndAddItemUnderPrice(int maxPrice) {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        int addedCount = 0;

        boolean morePages = true;

        while (morePages) {
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("div[role='listitem'][data-component-type='s-search-result']")
            ));

            List<WebElement> items = productsList;

            for (WebElement item : items) {
                WebElement priceElement = item.findElement(By.cssSelector("span.a-price-whole"));
                int price = extractWholePrice(item, priceElement);

                if (price < maxPrice) {
                    WebElement addToCartBtn = item.findElement(
                            By.cssSelector("button[name='submit.addToCart']")
                    );
                    ((JavascriptExecutor) Hooks.driver).executeScript("arguments[0].click();", addToCartBtn);
                    addedCount++;
                }
            }

            List<WebElement> nextButtons = Hooks.driver.findElements(By.cssSelector("a.s-pagination-next"));
            if (nextButtons.isEmpty() || !nextButtons.get(0).isDisplayed()) {
                morePages = false;
            } else {
                nextButtons.get(0).click();
                wait.until(ExpectedConditions.stalenessOf(items.get(0)));
            }
        }

        return addedCount;
    }


    public int getCartCount() {
        WebElement cartCountElement = cartCount;
        String countText = cartCountElement.getText().trim();
        return countText.isEmpty() ? 0 : Integer.parseInt(countText);
    }

    public WebElement getCartNavigate() {
        return cartNavigate;
    }
}
