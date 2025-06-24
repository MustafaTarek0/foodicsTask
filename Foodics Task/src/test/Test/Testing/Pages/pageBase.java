package Testing.Pages;

import Testing.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class pageBase {
    public  pageBase()
    {
        PageFactory.initElements(Hooks.driver, this);

    }


    public int extractWholePrice(WebElement item , WebElement itemPrice) {
        try {
            String price = item.findElement(By.cssSelector("span.a-price-whole")).getText().replace(",", "").trim();
            return Integer.parseInt(price);
        } catch (Exception e) {
            return Integer.MAX_VALUE;
        }
    }



   // public boolean goToNextPage() {
     //   try {
         //   WebElement nextButton = Hooks.driver.findElement(By.cssSelector("a.s-pagination-next"));
       //     clickElement(nextButton);
       //     return true;
    //    } catch (NoSuchElementException e) {
    //        return false;
   //     }
  //  }
    public void clickMenuItemByText(String itemText, List<WebElement> menuItems) {
        for (WebElement item : menuItems) {
            if (item.getText().trim().equalsIgnoreCase(itemText)) {
                ((JavascriptExecutor) Hooks.driver).executeScript("arguments[0].click();", item);
                break;
            }
        }
    }
}
