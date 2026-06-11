package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.DriverFactory;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        driver = DriverFactory.initDriver();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
    
}
