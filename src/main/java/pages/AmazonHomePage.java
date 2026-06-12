package pages;

import java.time.Duration;
import java.util.List;

import org.bouncycastle.asn1.eac.PublicKeyDataObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage {

    WebDriver driver;

    By searchBox = By.id("twotabsearchtextbox");
    By searchButton = By.id("nav-search-submit-button");
    By bookTitles = By.xpath("//h2/span");
    By addTocart_btn = By.id("add-to-cart-button");

    public AmazonHomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void searchBook(String keyword)
    {
        driver.findElement(searchBox).sendKeys(keyword);
        driver.findElement(searchButton).click();
    }

    public boolean isBookPresent(String bookName)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(bookTitles));

        List<WebElement> books = driver.findElements(bookTitles);

        for(WebElement book : books)
        {
            if(book.getText().toLowerCase().contains(bookName.toLowerCase()))
            {
                return true;
            }
        }
        return false;
    }
    
    public void addFirstProductToCart(){
    	
    	driver.findElements(addTocart_btn).get(0).click(); 
    	
    }
    	
   
   
}