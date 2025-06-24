package Testing.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Hooks {

    public static WebDriver driver;

    @Before("@UI")
    public static void setupDriver()  {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        EdgeOptions edge = new EdgeOptions();
        driver = new EdgeDriver(edge);
        driver.manage().window().maximize();



    }



    @After("@UI")
    public static void quitDriver()  {

      // driver.close();

    }


}
